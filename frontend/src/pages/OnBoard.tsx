import React from "react";
import styled from "styled-components";
import Logo from "../images/logo.png";

function OnBoard() {
  return (
    <Wrapper>
      <img src={Logo} alt="load-logo" />
      <Title className="hana-bold">하나로 연결된 모두의 스포츠</Title>
    </Wrapper>
  );
}

export default OnBoard;

const Title = styled.p`
  font-size: 26px;
  text-align: center;
  transform: translateY(50%);
  color: white;
`;

const Wrapper = styled.div`
  img {
    width: 241px;
  }
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  transform: translateY(50%);
`;
