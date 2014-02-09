SUMMARY = "Init script to start and stop SyntroLCam"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "syntrolcam"

SRC_URI = "file://init \
           file://default \
          "

PR = "0"

S = "${WORKDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "syntrolcam"
INITSCRIPT_PARAMS = "start 97 5 .  stop 3 0 6 ."

do_install_append () {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 init ${D}${sysconfdir}/init.d/syntrolcam

    install -d ${D}${sysconfdir}/default
    install -m 0666 default ${D}${sysconfdir}/default/syntrolcam
}

FILES_${PN} = "${sysconfdir}"

