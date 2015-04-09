#!/bin/sh
set -x
mkdir -p lib
cd lib
file=bulldog.beagleboneblack.hardfp-0.1.0.zip
wget "https://github.com/Datenheld/Bulldog/blob/Version-0.1.0/dist/Version-0.1.0/bulldog.beagleboneblack.hardfp/$file?raw=true"
mv $file\?raw\=true $file
unzip $file
rm $file

