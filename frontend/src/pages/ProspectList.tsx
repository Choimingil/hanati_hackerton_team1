import React from "react";
import Header from "../components/Header";
import { ListContainer } from "./ProList";
import ProspectUserBox from "../components/ProspectUserBox";
import CitizenTitle from "../images/citizen_title.png";
import UnderBar from "../components/UnderBar";
import styled from "styled-components";

const data = [
  {
    id: 1,
    name: "신현창",
    cntSub: 1001,
    profile: "img/pro_temp_img.png",
    position: "ST",
  },
  {
    id: 2,
    name: "신현창",
    cntSub: 1001,
    profile: "img/pro_temp_img.png",
    position: "ST",
  },
  {
    id: 3,
    name: "신현창",
    cntSub: 1001,
    profile: "img/pro_temp_img.png",
    position: "ST",
  },
  {
    id: 4,
    name: "신현창",
    cntSub: 1001,
    profile: "img/pro_temp_img.png",
    position: "ST",
  },
  {
    id: 5,
    name: "신현창",
    cntSub: 1001,
    profile: "img/pro_temp_img.png",
    position: "ST",
  },
  {
    id: 6,
    name: "신현창",
    cntSub: 1001,
    profile: "img/pro_temp_img.png",
    position: "ST",
  },
  {
    id: 7,
    name: "신현창",
    cntSub: 1001,
    profile: "img/pro_temp_img.png",
    position: "ST",
  },
  {
    id: 8,
    name: "신현창",
    cntSub: 1001,
    profile: "img/pro_temp_img.png",
    position: "ST",
  },
];

function ProspectList() {
  return (
    <>
      <Header title="유망주 목록" />
      <img src={CitizenTitle} alt="title_img" />

      <ProspectListContainer>
        {data.map(dt => (
          <ProspectUserBox id={dt.id} name={dt.name} cntSub={dt.cntSub} profile={dt.profile} position={dt.position} />
        ))}
      </ProspectListContainer>
      <UnderBar />
    </>
  );
}

export default ProspectList;

const ProspectListContainer = styled(ListContainer)`
  height: 570px;
`;
