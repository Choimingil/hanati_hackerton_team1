import React, { useState, useEffect } from "react";
import axios from "axios";
import Header from "../components/Header";
import { ListContainer } from "./ProList";
import ProspectUserBox from "../components/ProspectUserBox";
import CitizenTitle from "../f_images/citizen_title.png";
import UnderBar from "../components/UnderBar";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";


function ProspectList() {
  const navigation = useNavigate();

  const [users, setUsers] = useState([
    {
      id: 1,
      name: "",
      cntSub: 0,
      profile: "",
      position: "",
    },
  ]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/prospects")
      .then(response => {
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
            cntSub={dt.cntSub+20000}
            profile={dt.profile}
            position={dt.position}
            onClick={() => navigation(`/prospectDetail/${dt.id}`)}
          />
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
