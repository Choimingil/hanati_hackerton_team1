import React, { ChangeEvent, useState, useRef } from "react";
import Header from "../components/Header";
import styled from "styled-components";
import UnderBar from "../components/UnderBar";
import PlusIcon from "../images/plus_icon.png";
import { TextField, Input, Button } from "@mui/material";
import { DatePicker } from "@mui/lab";
import AdapterDateFns from "@mui/lab/AdapterDateFns";
import CloudUploadIcon from "@mui/icons-material/CloudUpload";

const VisuallyHiddenInput = styled("input")({
  clip: "rect(0 0 0 0)",
  clipPath: "inset(50%)",
  height: 1,
  overflow: "hidden",
  position: "absolute",
  bottom: 0,
  left: 0,
  whiteSpace: "nowrap",
  width: 1,
});

type ProspectValueProps = {
  profile_img: Blob | null;
  name: String;
  birth_date: Date;
  nation: String;
  weight: String;
  height: String;
  vision: String;
  effort: String;
  advantage: String;
  video: File | null;
};

function RegistProspect() {
  const [image, setImage] = useState<string | null>(null);
  const [imageFile, setImageFile] = useState<Blob | null>(null);
  const [fileName, setFileName] = useState("동영상을 업로드해주세요.");
  const inputFileRef = useRef<HTMLInputElement>(null);
  const handleInputClick = () => {
    inputFileRef.current?.click();
  };
  const handleFileChange = (event: ChangeEvent<HTMLInputElement>) => {
    const file = event.target.files?.[0];
    if (file) {
      setFileName(file.name);
    }
  };
  const [prospectValue, setProspectValue] = useState<ProspectValueProps>({
    profile_img: null,
    name: "",
    birth_date: new Date(),
    nation: "",
    weight: "",
    height: "",
    vision: "",
    effort: "",
    advantage: "",
    video: null,
  });
  const handleImageChange = (event: ChangeEvent<HTMLInputElement>) => {
    const file = event.target.files![0];
    setImageFile(file);
    if (file) {
      const reader = new FileReader();
      reader.onloadend = () => {
        setImage(reader.result as string);
      };
      reader.readAsDataURL(file);
    }
  };
  return (
    <>
      <Header title="유망주 등록" />
      <Wrapper>
        <TopBox>
          <LeftBox>
            <input ref={inputFileRef} type="file" onChange={handleImageChange} accept="image/*" hidden />
            {image ? (
              <PreviewImage src={image} alt="image-preview" onClick={handleInputClick} />
            ) : (
              <EmptyPreviewImage onClick={handleInputClick}>
                <img src={PlusIcon} alt="plus-icon" />
              </EmptyPreviewImage>
            )}
            <Input
              className="name_input"
              placeholder="이름"
              inputProps={prospectValue.name}
              onChange={ev => setProspectValue(value => ({ ...value, name: ev.target.value }))}
            />
          </LeftBox>
          <RightBox>
            <DatePicker
              label="생년월일"
              value={prospectValue.birth_date}
              onChange={(ev: Date) => setProspectValue(value => ({ ...value, birth_date: new Date(ev) }))}
              renderInput={() => <Input type="date" placeholder="생년월일" inputProps={prospectValue.birth_date} />}
            />
            <Input
              type="date"
              placeholder="생년월일"
              inputProps={prospectValue.birth_date}
              onChange={ev => setProspectValue(value => ({ ...value, birth_date: new Date(ev.target.value) }))}
            />
            <Input
              placeholder="국적"
              inputProps={prospectValue.nation}
              onChange={ev => setProspectValue(value => ({ ...value, nation: ev.target.value }))}
            />
            <Input
              type="number"
              placeholder="신장(cm)"
              value={prospectValue.height}
              inputProps={prospectValue.height}
              onChange={ev => setProspectValue(value => ({ ...value, height: ev.target.value }))}
            />
            <Input
              type="number"
              placeholder="체중(kg)"
              inputProps={prospectValue.weight}
              value={prospectValue.weight}
              onChange={ev => setProspectValue(value => ({ ...value, weight: ev.target.value }))}
            />
          </RightBox>
        </TopBox>
        <MiddleBox>
          <TextField
            id="outlined-textarea"
            label="비전"
            placeholder="비전"
            multiline
            rows={2}
            value={prospectValue.vision}
            onChange={ev => setProspectValue(value => ({ ...value, vision: ev.target.value }))}
          />
          <TextField
            id="outlined-textarea"
            label="비전을 위한 노력"
            placeholder="비전을 위한 노력"
            multiline
            rows={2}
            value={prospectValue.effort}
            onChange={ev => setProspectValue(value => ({ ...value, effort: ev.target.value }))}
          />
          <TextField
            id="outlined-textarea"
            label="장점"
            placeholder="장점"
            multiline
            rows={2}
            value={prospectValue.advantage}
            onChange={ev => setProspectValue(value => ({ ...value, advantage: ev.target.value }))}
          />
        </MiddleBox>
        <VideoBox>
          <VideoNameDiv>{fileName}</VideoNameDiv>
          <Button component="label" role={undefined} variant="outlined" tabIndex={-1} startIcon={<CloudUploadIcon />}>
            Upload file
            <VisuallyHiddenInput type="file" accept="video/*" onChange={handleFileChange} />
          </Button>
        </VideoBox>
        <RegistBox>
          <RegistButton className="hana-bold">등록하기</RegistButton>
        </RegistBox>
      </Wrapper>
      <UnderBar />
    </>
  );
}

export default RegistProspect;

const TopBox = styled.div`
  height: 210px;
  background-color: white;
  display: flex;
`;
const MiddleBox = styled.div`
  height: 330px;
  background-color: white;
  border-top: 1px solid gray;
  border-bottom: 1px solid gray;
  display: flex;
  align-items: center;
  flex-direction: column;
  justify-content: space-around;
  div {
    width: 400px;
  }
`;

const VideoBox = styled.div`
  background-color: white;
  text-align: center;
  padding-top: 20px;
`;

const LeftBox = styled.div`
  display: flex;
  flex: 1;
  flex-direction: column;
  width: 130px;
  .name_input {
    padding-left: 10px;
    border-right: 1px solid gray;
  }
`;

const RightBox = styled.div`
  display: flex;
  flex-direction: column;
  width: 300px;
  padding: 10px;
  gap: 10px;
  justify-content: space-around;
`;

const EmptyPreviewImage = styled.div`
  width: 130px;
  height: 178px;
  border: 1px solid gray;
  background-color: white;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  img {
    width: 30px;
    height: 30px;
  }
`;

const PreviewImage = styled.img`
  width: 130px;
  height: 178px;
  border: 1px solid gray;
  cursor: pointer;
`;

const VideoNameDiv = styled.div`
  width: 60%;
  height: 23px;
  display: inline-block;
  padding: 5px;
  border: 1px solid gray;
`;

const Wrapper = styled.div`
  height: 735px;
  background-color: white;
  overflow: scroll;
`;

const RegistButton = styled.button`
  width: 95%;
  height: 50px;
  text-align: center;
  border-radius: 10px;
  border: none;
  background-color: #008476;
  color: white;
  font-size: 18px;
  cursor: pointer;
`;

const RegistBox = styled.div`
  padding-top: 20px;
  border: none;
  text-align: center;
`;
