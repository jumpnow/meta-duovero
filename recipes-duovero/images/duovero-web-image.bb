SUMMARY = "A development image with nginx webserver"
HOMEPAGE = "http://www.jumpnowtek.com"
LICENSE = "MIT"

require duovero-console-image.bb

PR = "0"

IMAGE_INSTALL += " \
    nginx \
 "

export IMAGE_BASENAME = "duovero-web-image"

