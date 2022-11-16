import React from "react";

import Post from "./../../components/Post";



const Posts = (props) => {

    return (
        <div>
            {props.data.map(p => {
                return <Post
                    id={p.id}
                    key={p.id}
                    title={p.title}
                    author={p.author}
                    displayDetails={props.displayDetails}
                />

            })}
        </div>
    )





}

export default Posts;