import React, { useState, useEffect } from "react";
import styled from "styled-components";
import ProUserBox from "../components/ProUserBox";
import Header from "../components/Header";
import Amblem from "../f_images/amblem/hana_citizen_amblem.png";
import UnderBar from "../components/UnderBar";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function ProList() {
  const navigation = useNavigate();

  const [users, setUsers] = useState([
    {
      id: 1,
      profile: "",
      name: "",
      number: 0,
      price: 0,
      position: "",
    },
  ]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/teams/1")
      .then(response => {
        console.log(response);
        setUsers(response.data.data);
      })
      .catch(function (error) {
        console.log(error);
      });
  }, []);

  const makeProBox = () => {
    const boxes =
      users &&
      users.map(data => (
        <ProUserBox
          id={data.id}
          imgUrl={data.profile}
          name={data.name}
          number={data.number}
          price={data.price}
          position={data.position}
          onClick={() => navigation(`/proDetail/${data.id}`)}
        ></ProUserBox>
      ));

    return boxes;
  };

  return (
    <>
      <Header title="선수목록" />
      <TeamTitle>
        <img src={Amblem} alt="title_img" />
        <p className="hana-bold">대전 하나 시티즌</p>
      </TeamTitle>
      <ListContainer>{makeProBox()}</ListContainer>
      <UnderBar />
    </>
  );
}

export default ProList;

export const ListContainer = styled.div`
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  gap: 15px;
  align-items: center;
  justify-items: center;
  background-color: white;
  padding: 35px 0px 35px 0px;
  height: 585px;
  overflow: auto;
`;

export const TeamTitle = styled.div`
  width: 100%;
  height: 76px;
  img {
    width: 76px;
    height: 76px;
  }
  display: flex;
  align-items: center;
  color: black;
  background-color: white;
  gap: 20px;
  border-bottom: 1px solid gray;
`;
