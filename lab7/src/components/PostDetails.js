
import React from "react";

const PostDetails = (props) => {
    return (
        <div>
            {console.log(props)}
            <h1>{props.pdetails.title} </h1>
            <h4>{props.pdetails.author} </h4>
            <p> the content in selected post is ..</p>

            <button>Edit</button>

            <button>Delete</button>
        </div>
    );
}

export default PostDetails;