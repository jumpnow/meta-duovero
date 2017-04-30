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

PR = "r9"

PV = "4.9.25"
SRCREV = "a8c90ef62281db933118aa84489eb0e1e9cc347c"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.9.y \
    file://defconfig \
    file://0001-Revert-mfd-twl6040-The-chip-does-not-support-bulk-ac.patch \
    file://0002-ARM-omap4-Remove-gic-parent-from-usb-host.patch \
    file://0003-spidev-Add-spidev-compatible-id.patch \
    file://0004-Add-custom-dts-files.patch \
"
