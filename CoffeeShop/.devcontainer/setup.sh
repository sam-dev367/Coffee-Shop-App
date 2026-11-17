#!/bin/bash
set -e
SDK=$HOME/android-sdk
mkdir -p $SDK/cmdline-tools
cd /tmp
curl -fsSL -o cmdtools.zip https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip
unzip -q -o cmdtools.zip -d $SDK/cmdline-tools
rm -rf $SDK/cmdline-tools/latest
mv $SDK/cmdline-tools/cmdline-tools $SDK/cmdline-tools/latest
yes | $SDK/cmdline-tools/latest/bin/sdkmanager --licenses > /dev/null || true
$SDK/cmdline-tools/latest/bin/sdkmanager "platform-tools" "platforms;android-34" "build-tools;34.0.0"
cd /workspaces/* 2>/dev/null || cd "$OLDPWD"
echo "sdk.dir=$SDK" > local.properties
echo "Setup done. Run: gradle assembleDebug"
