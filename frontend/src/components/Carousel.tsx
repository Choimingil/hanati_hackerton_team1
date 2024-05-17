import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Slider from "react-slick";
import image_1 from "../images/carousel/carousel_1.png";
import image_2 from "../images/carousel/carousel_2.png";
import image_3 from "../images/carousel/carousel_3.jpeg";
import image_4 from "../images/carousel/carousel_4.jpeg";
import styled from "styled-components";

export default function Carousel() {
  var settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    arrows: false,
  };
  return (
    <Slider {...settings}>
        <img src={image_1} alt="img_1" />
        <img src={image_2} alt="img_2" />
        <img src={image_3} alt="img_3" />
        <img src={image_4} alt="img_4" />
    </Slider>
  );
}

