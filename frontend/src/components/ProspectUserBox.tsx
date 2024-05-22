import React from "react";
import { NameBox, ProUserDiv, ProUserImage } from "./ProUserBox";
import styled from "styled-components";
import formatMoney from "../util/formatMoney";

interface ProspectProps {
  id: number;
  name: string;
  cntSub: number;
  profile: string;
  position: string;
  onClick?: (event: React.MouseEvent<HTMLDivElement>) => void;
}

function ProspectUserBox({ id, name, cntSub, profile, position, onClick }: ProspectProps) {
  return (
    <ProUserDiv id={String(id)} onClick={onClick}>
      <ProUserImage src={profile} alt="prospect-img" />
      <NameBox className="hana-regular">
        <div>{position}</div> <p style={{ marginLeft: 10 }}>{name}</p>
      </NameBox>
      <SubBox>
        <span><b>Subscriber</b></span>
        <span>{formatMoney(cntSub)}</span>
      </SubBox>
    </ProUserDiv>
  );
}

export default ProspectUserBox;

const SubBox = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 60px;
  color: black;
  font-size: 16px;
  border: 1px solid gray;
  border-top: none;
  border-radius: 0px 0px 10px 10px;
  gap: 0;
  p {
    height: 10px;
  }
`;
