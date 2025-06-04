var containerZoom = "-smallImageCnt";
var smallImageCntClass = "iz-zoom";
// Default smallImageCntSize: 100px
var smallImageCntLen = 100;
// Default zoom size: 2
var zoomSize = 2;

function imageZoom(imageId, containerId) {
    var container = document.getElementById(containerId);
    container.addEventListener("mouseenter", createImageZoom());

    function createImageZoom() {
        var image, smallImageCnt, smallImageCntLeft, smallImageCntTop;
        var smallImageCntInstance = document.getElementById(imageId + containerZoom);
        if(smallImageCntInstance == null)
        {
            image = document.getElementById(imageId);
            smallImageCnt = document.createElement("DIV");
            smallImageCnt.className = smallImageCntClass;
            smallImageCnt.id = imageId + containerZoom;
            smallImageCnt.style.width = `${smallImageCntLen}px`;
            smallImageCnt.style.height = `${smallImageCntLen}px`;
            smallImageCnt.style.backgroundImage = `url('${image.src}')`;
            smallImageCnt.style.backgroundSize = `${image.width * zoomSize}px ${image.height * zoomSize}px`;
            image.parentElement.insertBefore(smallImageCnt, image);
            smallImageCntInstance = smallImageCnt;

            smallImageCntLeft = smallImageCnt.offsetLeft;
            smallImageCntTop = smallImageCnt.offsetTop;

            smallImageCnt.addEventListener("mousemove", moveSmallImageCnt);
            image.addEventListener("mousemove", moveSmallImageCnt);

            smallImageCnt.addEventListener("touchmove", moveSmallImageCnt);
            image.addEventListener("touchmove", moveSmallImageCnt);
        }
        smallImageCntInstance.style.display = "block";


        function moveSmallImageCnt(e) {
            var pos, x, y;

            e.preventDefault();

            pos = getCursorPos(e);

            x = pos.x - (smallImageCntLen / (zoomSize * 2));
            y = pos.y - (smallImageCntLen / (zoomSize * 2));

            if (x > image.width - smallImageCntLen / 2)
            {
                x = image.width - smallImageCntLen / 2;
            }
            if (x < 0)
            {
                x = 0;
            }
            if (y > image.height - smallImageCntLen / 2)
            {
                y = image.height - smallImageCntLen / 2;
            }
            if (y < 0)
            {
                y = 0;
            }

            var posX = pos.x;
            var posY = pos.y;
            if (posX > image.width)
            {
                posX = image.width;
                removeImageZoom();
            }
            if (posX < 0)
            {
                posX = 0;
                removeImageZoom();
            }
            if (posY > image.height)
            {
                posY = image.height;
                removeImageZoom();
            }
            if (posY < 0)
            {
                posY = 0;
                removeImageZoom();
            }

            smallImageCnt.style.left = `${smallImageCntLeft + posX - smallImageCntLen / 2}px`;
            smallImageCnt.style.top = `${smallImageCntTop + posY - smallImageCntLen / 2}px`;

            smallImageCnt.style.backgroundPosition = `-${x * zoomSize}px -${y * zoomSize}px`;
        }


        function getCursorPos(e) {
            var imagePos, x = 0, y = 0;
            e = e || window.event;

            imagePos = image.getBoundingClientRect();

            x = e.pageX - imagePos.left - window.pageXOffset;
            y = e.pageY - imagePos.top - window.pageYOffset;

            return {x : x, y : y};
        }
    }

    function removeImageZoom() {
        var smallImageCntInstance = document.getElementById(imageId + containerZoom);
        if(smallImageCntInstance != null)
        {
            smallImageCntInstance.style.display = "none";
        }
    }

}
