$(document).ready(function () {
  // custom dropdown
  $(".select-dropdown-button").on("click", function () {
    $(".select-dropdown-list").toggleClass("active");
    $(".select-dropdown-button i").toggleClass("active");
  });

  $(".select-dropdown-list-item").on("click", function () {
    var itemValue = $(this).data("value");
    console.log(itemValue);
    $(".select-dropdown-button span")
      .text($(this).text())
      .parent()
      .attr("data-value", itemValue);
    $(".select-dropdown-list").toggleClass("active");
  });

  // slider
  //active dot
  let total = $(".slick-dots>li").length;
  $(".slick-dots>li").css("height", "calc(200px /" + total + ")");

  const $slickElement = $(".image-slider");

  $slickElement.on(
    "init reInit afterChange",
    function (event, slick, currentSlide, nextSlide) {
      //currentSlide is undefined on init -- set it to 0 in this case (currentSlide is 0 based)
      let i = (currentSlide ? currentSlide : 0) + 1;
      $(".slick-dots .current-slide").remove();
      $(".slick-dots .total-slide").remove();

      $(".slick-dots").append("<div class='current-slide'>" + i + "</div>");
      $(".slick-dots").append(
        "<div class='total-slide'>" + slick.slideCount + "</div>"
      );
    }
  );

  $(".image-slider").slick({
    slidesToShow: 1,
    infinite: false,
    draggable: false,
    prevArrow: `<button class='slick-prev slick-arrow'>prev</button>`,
    dots: true,
  });

  //   click to scroll slide service
  const $prev = $(".prev");
  const $next = $(".next");
  const $content = $(".slide-service");
  $next.on("click", function () {
    event.preventDefault();
    $content.animate(
      {
        scrollLeft: "+=200px",
      },
      "fast"
    );
  });

  $prev.on("click", function () {
    event.preventDefault();
    $content.animate(
      {
        scrollLeft: "-=200px",
      },
      "fast"
    );
  });
});
