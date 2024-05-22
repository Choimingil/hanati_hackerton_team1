import React from "react";
import styled from "styled-components";
import ProUserBox from "../components/ProUserBox";
import Header from "../components/Header";
import Amblem from "../images/amblem/hana_citizen_amblem.png";
import UnderBar from "../components/UnderBar";
import { useNavigate } from "react-router-dom";

const tempData = [
  {
    id: 1,
    imgUrl: "img/pro_temp_img.png",
    name: "이승현",
    number: 1,
    price: 20000,
    position: "GK",
  },
  {
    id: 2,
    imgUrl: "img/pro_temp_img.png",
    name: "이승현",
    number: 10,
    price: 80000,
    position: "ST",
  },
  {
    id: 3,
    imgUrl: "img/pro_temp_img.png",
    name: "이승현",
    number: 30,
    price: 12832,
    position: "FW",
  },
  {
    id: 4,
    imgUrl: "img/pro_temp_img.png",
    name: "이승현",
    number: 99,
    price: 30018,
    position: "MF",
  },
  {
    id: 5,
    imgUrl: "img/pro_temp_img.png",
    name: "이승현",
    number: 92,
    price: 11213,
    position: "MF",
  },
  {
    id: 6,
    imgUrl: "img/pro_temp_img.png",
    name: "이승현",
    number: 0,
    price: 28193,
    position: "MF",
  },
  {
    id: 7,
    imgUrl: "img/pro_temp_img.png",
    name: "이승현",
    number: 99,
    price: 30018,
    position: "MF",
  },
];

function ProList() {
  const navigation = useNavigate();
  return (
    <>
      <Header title="선수목록" />
      <TeamTitle>
        <img src={Amblem} alt="title_img" />
        <p className="hana-bold">대전 하나 시티즌</p>
      </TeamTitle>
      <ListContainer>
        {tempData.map(data => (
          <ProUserBox
            id={data.id}
            imgUrl={data.imgUrl}
            name={data.name}
            number={data.number}
            price={data.price}
            position={data.position}
            onClick={() => navigation(`/proDetail/${data.id}`)}
          ></ProUserBox>
        ))}
      </ListContainer>
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
  height: 580px;
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
