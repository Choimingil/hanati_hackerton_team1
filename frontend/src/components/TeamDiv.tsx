import React from "react";
import styled from "styled-components";

interface TeamDivProps {
  teamName: string;
  teamLogo: string;
  onClick?: (event: React.MouseEvent<HTMLDivElement>) => void;
}

function TeamDiv({ teamName, teamLogo, onClick }: TeamDivProps) {
  return (
    <DivWrapper onClick={onClick}>
      <img src={teamLogo} alt="team-logo" />
      <TeamNameDiv>
        <p className="hana-medium">{teamName}</p>
      </TeamNameDiv>
    </DivWrapper>
  );
}

export default TeamDiv;

const DivWrapper = styled.div`
  width: 100%;
  border-radius: 10px;
  display: flex;
  img {
    width: 80px;
    height: 80px;
    border-radius: 10px 0px 0px 10px;
  }
  border: 1px solid black;
`;

const TeamNameDiv = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  padding-left: 20px;
`;
