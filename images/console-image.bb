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
    kernel-modules \
"

WIFI_SUPPORT = " \
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
    findutils \
    i2c-tools \
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

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${DEV_SDK_INSTALL} \
    ${DEV_EXTRAS} \
    ${EXTRA_TOOLS_INSTALL} \
    ${KERNEL_EXTRA_INSTALL} \
    ${WIFI_SUPPORT} \
 "

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

create_opt_dir() {
    mkdir -p ${IMAGE_ROOTFS}/opt
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
    create_opt_dir ; \
"

export IMAGE_BASENAME = "console-image"
