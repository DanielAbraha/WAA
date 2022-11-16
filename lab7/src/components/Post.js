
import React from "react";

const Post = (props) => {

    return (<ul onClick={() => props.displayDetails(props.id)}>
        <div>
            Id:{props.id}
        </div>

        <h1> Title:{props.title}</h1>
        <div>
            Author:{props.author}
        </div>
    </ul>);
}

export default Post;