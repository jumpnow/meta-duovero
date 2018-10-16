SUMMARY = "U-boot boot script for duovero"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

COMPATIBLE_MACHINE = "duovero"

inherit deploy

DEPENDS = "u-boot-mkimage-native"

SRC_URI = "file://boot.cmd \
           file://upgrader-boot.cmd \
          "

do_compile() {
    if [ -n "${SD_UPGRADER_BOOT}" ]; then
        mkimage -A arm -T script -C none -n "Boot script" -d "${WORKDIR}/upgrader-boot.cmd" boot.scr
    else
        mkimage -A arm -T script -C none -n "Boot script" -d "${WORKDIR}/boot.cmd" boot.scr
    fi
}

# Current u-boot 2018.01 does not look for boot.scr here on the rootfs
# partition. It looks on the FAT partition alongside the u-boot binary.
# Next version of u-boot might though so leave here as example. 
do_install() {
    install -d ${D}/boot
    install -m 0644 boot.scr ${D}/boot
}

# This copies the boot.scr to the deploy dir where we copy_boot.sh
# will pick it up.
do_deploy() {
    install -d ${DEPLOYDIR}
    install -m 0644 boot.scr ${DEPLOYDIR}/boot.scr
}

addtask deploy before do_build after do_compile
 
FILES_${PN} = "/boot"
