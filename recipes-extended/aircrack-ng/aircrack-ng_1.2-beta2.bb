DESCRIPTION = "Aircrack-ng is a set of tools for wep key statistical cracking"
HOMEPAGE = "http://www.aircrack-ng.org/"
SECTION = "console/network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "openssl zlib sqlite3"

SRC_URI = "http://download.aircrack-ng.org/aircrack-ng-1.2-beta2.tar.gz \
           file://remove-host-path-in-makefile.patch \
           file://remove-host-path-in-common-mak.patch \
          "

SRC_URI[md5sum] = "f1c0f1d5e7eb063e40e109283599356b"
SRC_URI[sha256sum] = "ef7181f15462767249fde88219a503f27a7aee6f98b38e7e7d33a7b32880fbde"
 
export TOOL_PREFIX = "${HOST_SYS}-"

do_compile() {
    oe_runmake SQLITE=true
}

do_install() {
    install -d ${D}/${sbindir}
    install -d ${D}/${bindir}
    install -m 0755 src/aireplay-ng       ${D}/${sbindir}
    install -m 0755 src/airserv-ng        ${D}/${sbindir}
    install -m 0755 src/makeivs-ng        ${D}/${bindir}
    install -m 0755 src/airolib-ng        ${D}/${bindir}
    install -m 0755 src/besside-ng        ${D}/${sbindir}
    install -m 0755 src/airdecap-ng       ${D}/${bindir}
    install -m 0755 src/airtun-ng         ${D}/${sbindir}
    install -m 0755 src/airbase-ng        ${D}/${sbindir}
    install -m 0755 src/aircrack-ng       ${D}/${bindir}
    install -m 0755 src/ivstools          ${D}/${bindir}
    install -m 0755 src/wpaclean          ${D}/${bindir}
    install -m 0755 src/airdecloak-ng     ${D}/${bindir}
    install -m 0755 src/kstats            ${D}/${bindir}
    install -m 0755 src/packetforge-ng    ${D}/${bindir}
    install -m 0755 src/airodump-ng       ${D}/${sbindir}
    install -m 0755 scripts/airmon-ng     ${D}/${sbindir}
}

