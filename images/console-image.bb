SUMMARY = "A console development image customized for the duovero"
HOMEPAGE = "http://www.jumpnowtek.com"

require images/basic-dev-image.bb


WIFI = " \
    crda \
    iw \
    linux-firmware-sd8787 \
    wpa-supplicant \
"

IMAGE_INSTALL += " \
    firewall \
    serialecho \
    root-upgrader \
    u-boot-scr \
    ${SECURITY_TOOLS} \
    ${WIREGUARD} \
"

export IMAGE_BASENAME = "console-image"
