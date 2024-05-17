import React from "react";
import styled from "styled-components";
import ProIcon from "../images/underbarIcon/pro_icon.png"
import YouthIcon from "../images/underbarIcon/youth_icon.png"
import ComIcon from "../images/underbarIcon/community_icon.png"
import MypageIcon from "../images/underbarIcon/mypage_icon.png"


function UnderBar() {
  return (
    <BarDiv>
        <BarIcon src={ComIcon} />
        <BarIcon src={ProIcon} />
        <BarIcon src={YouthIcon} />
        <BarIcon src={MypageIcon} />
    </BarDiv>
  );
}

export default UnderBar;

const BarDiv = styled.div`
  width: 430px;
  height: 72px;
  display: flex;
  justify-content: space-around;
  align-items: center;
  position: fixed;
  bottom: 0;
  z-index: 1;
`;

const BarIcon = styled.img`
    width:37px;
    height: 37px;
    cursor: pointer;
`
