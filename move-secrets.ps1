$ErrorActionPreference = 'Stop'
$configPath = Join-Path $PSScriptRoot 'src/main/resources/application.yaml'
$configText = [IO.File]::ReadAllText($configPath)
$settings = @(
    @{ Pattern = '(?m)^(\s*api-key:)\s*(.+)$'; Name = 'OPENROUTER_API_KEY' },
    @{ Pattern = '(?m)^(\s*password:)\s*(.+)$'; Name = 'DB_PASSWORD' },
    @{ Pattern = '(?m)^(\s*access-key:)\s*(.+)$'; Name = 'MINIO_ACCESS_KEY' }
)
foreach ($setting in $settings) {
    $entry = [regex]::Match($configText, $setting.Pattern)
    if (-not $entry.Success) { throw "Missing setting: $($setting.Name)" }
    $secretValue = $entry.Groups[2].Value.Trim()
    if (-not $secretValue.StartsWith('${')) {
        [Environment]::SetEnvironmentVariable($setting.Name, $secretValue, 'User')
    }
    $replacement = $entry.Groups[1].Value + ' ${' + $setting.Name + '}'
    $configText = $configText.Replace($entry.Value, $replacement)
}
$jwtEntry = [regex]::Match($configText, '(?m)^(\s*secret-key:)\s*\$\{JWT_SECRET_KEY:([^}]+)\}')
if ($jwtEntry.Success) {
    if (-not [Environment]::GetEnvironmentVariable('JWT_SECRET_KEY', 'User')) {
        [Environment]::SetEnvironmentVariable('JWT_SECRET_KEY', $jwtEntry.Groups[2].Value, 'User')
    }
    $configText = $configText.Replace($jwtEntry.Value, $jwtEntry.Groups[1].Value + ' ${JWT_SECRET_KEY}')
}
$minioEntry = [regex]::Match($configText, '(?m)^(  secret-key:)\s*([^$\r\n][^\r\n]*)$')
if ($minioEntry.Success) {
    [Environment]::SetEnvironmentVariable('MINIO_SECRET_KEY', $minioEntry.Groups[2].Value.Trim(), 'User')
    $configText = $configText.Replace($minioEntry.Value, $minioEntry.Groups[1].Value + ' ${MINIO_SECRET_KEY}')
}
[IO.File]::WriteAllText($configPath, $configText)
foreach ($name in @('OPENROUTER_API_KEY','DB_PASSWORD','JWT_SECRET_KEY','MINIO_ACCESS_KEY','MINIO_SECRET_KEY','STRIPE_API_SECRET','STRIPE_WEBHOOK_SECRET')) {
    $savedValue = [Environment]::GetEnvironmentVariable($name, 'User')
    if (-not $savedValue) {
        $savedValue = [Environment]::GetEnvironmentVariable($name, 'Process')
        if ($savedValue) { [Environment]::SetEnvironmentVariable($name, $savedValue, 'User') }
    }
    Write-Output "$name saved: $([bool]$savedValue)"
}
