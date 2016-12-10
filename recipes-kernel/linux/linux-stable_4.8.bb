require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "duovero"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE = " \
    omap4-duovero-parlor.dtb \
    jumpnow-duovero-parlor.dtb \
    jumpnow-duovero-parlor-nodisplay.dtb \
 "

LINUX_VERSION = "4.8"
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-4.8:"

S = "${WORKDIR}/git"

PR = "r3"

PV = "4.8.13"
SRCREV = "55d64c0b3c15cb5fb4d5a5bdebde9522e4ed52ff"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.8.y \
    file://defconfig \
    file://0001-ARM-omap4-wakeupgen-Remove-gic-parent-from-usb-host.patch \
    file://0002-spidev-Add-a-generic-compatible-id.patch \
    file://0003-Add-custom-dts-files.patch \
 "
