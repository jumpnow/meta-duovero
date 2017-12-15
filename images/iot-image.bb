SUMMARY = "A console development image with some iot tools"
HOMEPAGE = "http://www.jumpnowtek.com"

require console-image.bb

MQTT = " \
    libmosquitto1 \
    libmosquittopp1 \
    mosquitto \
    mosquitto-dev \
    mosquitto-clients \
    python-paho-mqtt \
"

IMAGE_INSTALL += " \
    ${MQTT} \
 "

export IMAGE_BASENAME = "iot-image"
