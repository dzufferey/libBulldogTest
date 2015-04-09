# libbulldog test

Testing [libbulldog](http://libbulldog.org/bulldog/) with scala on a Debian/Ubuntu system.

To download libbulldog you can simply run the `getLibBulldog.sh` script.

## sbt memory options

sbt tends is usually run on machines with lots of RAM.
However, when developing on small platform for embedded system, this might not be the case.
You can always develop on another machine and upload only the jar files.
But I was able to develop and test directly on a BeagleBone Black running Debian and the JDK 1.8 by running sbt with `-Xms64M -Xmx256M -Xss1M -XX:+CMSClassUnloadingEnabled`.
