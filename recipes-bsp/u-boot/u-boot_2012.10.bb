require u-boot.inc

PV = "2012.10"
PR = "r1"

SRCREV = "6299a25343aba35f493fbe575b0852e58874e8b0"
SRC_URI = "git://github.com/gumstix/u-boot.git;branch=omap-v2012.10;protocol=git \
           file://fw_env.config \
          "
SPL_BINARY = "MLO"

