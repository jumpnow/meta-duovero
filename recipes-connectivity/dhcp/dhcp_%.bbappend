FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PR = "r1"

inherit update-rc.d
INITSCRIPT_PACKAGES = "dhcp-server"
INITSCRIPT_NAME = "dhcp-server"
INITSCRIPT_PARAMS = "start 50 5 . stop 50 0 6 1 ."

