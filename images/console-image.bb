SUMMARY = "A console development image with some C/C++ dev tools"
HOMEPAGE = "http://www.jumpnowtek.com"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

inherit image

CORE_OS = " \
    busybox-hwclock \
    openssh openssh-keygen openssh-sftp-server \
    packagegroup-core-boot \
    term-prompt \
    tzdata \
    u-boot-scr \
"

KERNEL_EXTRA_INSTALL = " \
    cryptodev-module \
    kernel-modules \
    load-modules \
"

WIREGUARD = " \
    wireguard-init \
    wireguard-module \
    wireguard-tools \
"

WIFI = " \
    crda \
    iw \
    linux-firmware-sd8787 \
    wpa-supplicant \
"

DEV_SDK_INSTALL = " \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    elfutils elfutils-binutils \
    file \
    g++ \
    g++-symlinks \
    gcc \
    gcc-symlinks \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    make \
    pkgconfig \
    python-modules \
"

DEV_EXTRAS = " \
    serialecho \
"

EXTRA_TOOLS_INSTALL = " \
    bzip2 \
    cpufrequtils \
    devmem2 \
    dosfstools \
    ethtool \
    file \
    findutils \
    firewall \
    i2c-tools \
    ifupdown \
    iperf3 \
    less \
    lsof \
    netcat-openbsd \
    nmap \
    ntp ntp-tickadj \
    procps \
    rndaddtoentcnt \
    root-upgrader \
    sysfsutils \
    tcpdump \
    unzip \
    util-linux \
    util-linux-blkid \
    wget \
    zip \
"

SECURITY_TOOLS = " \
    checksec \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${EXTRA_TOOLS_INSTALL} \
    ${KERNEL_EXTRA_INSTALL} \
    ${SECURITY_TOOLS} \
    ${WIREGUARD} \
"

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

disable_rng_daemon() {
    rm -f ${IMAGE_ROOTFS}/etc/rcS.d/S*rng-tools
    rm -f ${IMAGE_ROOTFS}/etc/rc5.d/S*rng-tools
}

create_opt_dir() {
    mkdir -p ${IMAGE_ROOTFS}/opt
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
    disable_rng_daemon ; \
    create_opt_dir ; \
"

export IMAGE_BASENAME = "console-image"
