import React from "react";
import styled from "styled-components";
import ProIcon from "../images/underbarIcon/pro_icon.png"
import YouthIcon from "../images/underbarIcon/youth_icon.png"
import ComIcon from "../images/underbarIcon/community_icon.png"
import MypageIcon from "../images/underbarIcon/mypage_icon.png"
import { useNavigate } from "react-router-dom";

function UnderBar() {
  const navigation = useNavigate();
  return (
    <BarDiv>
        <BarIcon src={ComIcon} onClick={() => navigation("/community")}/>
        <BarIcon src={ProIcon} onClick={() => navigation("/proList")}/>
        <BarIcon src={YouthIcon} onClick={() => navigation("/youthList")}/>
        <BarIcon src={MypageIcon} onClick={() => navigation("/mypage")}/>
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
