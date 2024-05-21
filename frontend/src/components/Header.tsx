import React from "react";
import styled from "styled-components";
import NotiIcon from "../images/noti_icon.png";
import { useNavigate } from "react-router-dom";

interface HeadProps {
  title: string;
}

function Header({ title }: HeadProps) {
  const navigation = useNavigate();
  return (
    <HeadWrapper className="hana-bold">
      <p onClick={() => navigation(-1)}>◀︎</p>
      {title}
      <img src={NotiIcon} alt="noti-icon" />
    </HeadWrapper>
  );
}

export default Header;

const HeadWrapper = styled.div`
  width: 100%;
  height: 34px;
  background-color: #008476;
  display: flex;
  justify-content: space-between;
  align-items: center;
  color: white;
  img {
    cursor: pointer;
  }
  p {
    font-size: 24px;
    cursor: pointer;
  }
`;
