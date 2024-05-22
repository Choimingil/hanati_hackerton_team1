import React, { useState, useEffect } from "react";
import axios from "axios";
import Header from "../components/Header";
import { ListContainer } from "./ProList";
import ProspectUserBox from "../components/ProspectUserBox";
import CitizenTitle from "../images/citizen_title.png";
import UnderBar from "../components/UnderBar";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";

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
  const navigation = useNavigate();

  const [users, setUsers] = useState([{
    id: 1,
    name: "",
    cntSub: 0,
    profile: "",
    position: "",
  }]);

  useEffect(() => {
    axios.get('http://localhost:8080/prospects')
      .then(response => {
        console.log(response);
        setUsers(response.data.data);
      })
      .catch(function (error) {
        console.log(error);
      });
  }, []);


  return (
    <>
      <Header title="유망주 목록" />
      <img src={CitizenTitle} alt="title_img" />

      <ProspectListContainer>
        {users.map(dt => (
          <ProspectUserBox
            id={dt.id}
            name={dt.name}
            cntSub={dt.cntSub}
            profile={dt.profile}
            position={dt.position}
            onClick={() => navigation(`/prospectDetail/${dt.id}`)} />
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
