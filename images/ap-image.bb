SUMMARY = "An Duovero access point"
HOMEPAGE = "http://www.jumpnowtek.com"

require console-image.bb

AP_TOOLS = " \
    hostapd \
    iptables \
    dnsmasq \
"

IMAGE_INSTALL += " \
    ${AP_TOOLS} \
"

export IMAGE_BASENAME = "ap-image"
