SUMMARY = "Init script to add some iptable rules"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit update-rc.d
INITSCRIPT_NAME = "firewall"
INITSCRIPT_PARAMS = "start 60 5 . stop 2 0 6 1 ."

SRC_URI = "file://init \
           file://default \
          "

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 init ${D}${sysconfdir}/init.d/firewall
    install -d ${D}${sysconfdir}/default
    install -m 0666 default ${D}${sysconfdir}/default/firewall
}

FILES_${PN} = "${sysconfdir}"

