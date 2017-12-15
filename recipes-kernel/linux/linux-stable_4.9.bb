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

PR = "r3"

PV = "4.9.69"
SRCREV = "c91efc7862b3f3c61cb76e926990cdbff5354b57"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.9.y \
    file://defconfig \
    file://0001-Revert-mfd-twl6040-The-chip-does-not-support-bulk-ac.patch \
    file://0002-ARM-omap4-Remove-gic-parent-from-usb-host.patch \
    file://0003-spidev-Add-spidev-compatible-id.patch \
    file://0004-Add-custom-dts-files.patch \
    file://0005-mwifiex-Skip-unsupported-CHAN_REGION_CFG-cmd.patch \
    file://0006-mwifiex-Remove-unsupported-GTK_REKEY_OFFLOAD_CFG-cmd.patch \
"
