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

PR = "r1"

PV = "4.8.10"
SRCREV = "cf5ae2989a32c391d7769933e0267e6fbfae8e14"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.8.y \
    file://defconfig \
    file://0001-ARM-omap4-wakeupgen-Remove-gic-parent-from-usb-host.patch \
    file://0002-spidev-Add-a-generic-compatible-id.patch \
    file://0003-Add-custom-dts-files.patch \
 "
