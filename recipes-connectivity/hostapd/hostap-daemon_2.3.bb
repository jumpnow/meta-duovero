HOMEPAGE = "http://hostap.epitest.fi"
SECTION = "kernel/userland"
LICENSE = "GPLv2 | BSD"
LIC_FILES_CHKSUM = "file://README;md5=a07250b28e857455336bb59fc31cb845"
DEPENDS = "libnl openssl"
DESCRIPTION = "User space daemon for extended IEEE 802.11 management"

inherit update-rc.d
INITSCRIPT_NAME = "hostapd"

PR = "r1"

# v2.3 
SRCREV = "724fce8fff27e18dd4ebeec9481b958eb5628ee9"

SRC_URI = " \
    git://w1.fi/hostap.git \
    file://0001-remove-absolute-include-path-for-libnl3.patch \
    file://0002-revert-a6cc060-breaks-duovero.patch \
    file://duovero-defconfig \
    file://duovero-hostapd.conf \
    file://init \
    file://default \
"

S = "${WORKDIR}/git"

do_configure() {
    install -m 0644 ${WORKDIR}/duovero-defconfig ${S}/hostapd/.config
}

do_compile() {
    cd hostapd
    export CFLAGS="-MMD -O2 -Wall -I${STAGING_INCDIR}/libnl3"
    make
}

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/hostapd

    install -d ${D}${sysconfdir}/default/
    install -m 0644 ${WORKDIR}/default ${D}${sysconfdir}/default/hostapd

    install -m 0644 ${WORKDIR}/duovero-hostapd.conf ${D}${sysconfdir}/hostapd.conf

    install -d ${D}${sbindir}
    install -m 0755 ${S}/hostapd/hostapd ${D}${sbindir}
    install -m 0755 ${S}/hostapd/hostapd_cli ${D}${sbindir}
}

FILES_${PN} += "${sysconfdir} ${sbindir}"

