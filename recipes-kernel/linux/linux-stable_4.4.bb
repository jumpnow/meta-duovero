require recipes-kernel/linux/linux-yocto.inc

COMPATIBLE_MACHINE = "duovero"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE ?= "omap4-duovero-parlor.dtb"

LINUX_VERSION = "4.4"
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-${LINUX_VERSION}:"

S = "${WORKDIR}/git"

PV = "4.4.109"
SRCREV = "e68d6189c7872b2b3731276bda5f5e0c8d5ba644"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-${LINUX_VERSION}.y \
    file://defconfig \
    file://0001-ARM-omap4-wakeupgen-Remove-gic-parent-from-usb-host.patch \
    file://0002-spidev-Add-a-generic-compatible-id.patch \
    file://0003-Add-custom-dts-files.patch \
    file://0004-rtc-twl-Enable-battery-charging.patch \
"
