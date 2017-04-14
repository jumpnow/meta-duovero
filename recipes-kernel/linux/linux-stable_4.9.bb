require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "duovero"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE = " \
    omap4-duovero-parlor.dtb \
    jumpnow-duovero-parlor.dtb \
    jumpnow-duovero-parlor-nodisplay.dtb \
 "

LINUX_VERSION = "4.9"
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-4.9:"

S = "${WORKDIR}/git"

PR = "r5"

PV = "4.9.22"
SRCREV = "cf2586e60ede2217d7f53a0585e27e1cca693600"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.9.y \
    file://defconfig \
    file://0001-ARM-omap4-Remove-gic-parent-from-usb-host.patch \
    file://0002-spidev-Add-a-generic-compatible-id.patch \
    file://0003-Add-custom-dts-files.patch \
 "
