# SnapDim

A very simple application that calculates relative luminance and proceeds to
call xbacklight.


http://en.wikipedia.org/wiki/Luminance_(relative)

## Run

I recommend using https://github.com/sbt/sbt-start-script to generate a runner.

## Crontab

Example: runs snapdim every 10 minutes

*/10 * * * * export DISPLAY=:0; source /etc/profile; /home/tzbob/clones/snapdim/target/start

The X Display has to be set for xbacklight to work and the java command has to be available which can be done by sourcing the profile.
