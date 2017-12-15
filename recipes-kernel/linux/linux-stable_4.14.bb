require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "duovero"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE = " \
    omap4-duovero-parlor.dtb \
"

LINUX_VERSION = "4.14"
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-4.14:"

S = "${WORKDIR}/git"

PR = "r1"

PV = "4.14.6"
SRCREV = "5fd159e1ee6a87a72626139813034f24f047d0e6"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.14.y \
    file://defconfig \
    file://0001-Revert-mfd-twl6040-The-chip-does-not-support-bulk-ac.patch \
    file://0002-ARM-omap4-Remove-gic-parent-from-usb-host.patch \
    file://0003-spidev-Add-spidev-compatible-id.patch \
    file://0004-mwifiex-Skip-unsupported-CHAN_REGION_CFG-cmd.patch \
    file://0005-mwifiex-Remove-unsupported-GTK_REKEY_OFFLOAD_CFG-cmd.patch \
"
