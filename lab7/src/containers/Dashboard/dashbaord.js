import React from "react";
import { useState } from "react";
import PostDetails from "./../../components/PostDetails";
import Posts from "./../Posts/Posts";


const DashBoard = () => {


    const [selected, setSelected] = useState(0);

    const [postsState, setPosts] = useState([

        { id: 111, title: "Happiness", author: "Jhon" },
        { id: 112, title: "MIU", author: "Dean" },
        { id: 113, title: "Enjoy Life", author: "Jasmine" }
    ]

    );

    const [showPostDetail, setShowPostDetail] = useState(false)
    const [title, setTitle] = useState("");
    const [postDetail, setPostDetail] = useState({
        id: "", title: "", author: ''
    })

    const changeTitle = () => {
        const copy = [...postsState]
        copy[0].title = title
        setPosts(copy)
    }

    const displayDetails = (id) => {
        const showDetails = postsState.find(i => i.id === id)
        setPostDetail(showDetails)
        setShowPostDetail(true)

    }





    return (

        <div>
            <Posts
                data={postsState}
                displayDetails={displayDetails}
            />
            <div className="label">
                <input type="text" id="text" title="title" onChange={(t) => setTitle(t.target.value)} /><br />
                <button className="button" onClick={changeTitle}>Change Title</button>

            </div>
            {showPostDetail && < PostDetails
                pdetails={postDetail} />}
        </div>



    );
}

export default DashBoard;