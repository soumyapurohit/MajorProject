<center><h2>Upload <b>Status</b> or <b>Post a Picture/Video etc</b> to the Network</h2>
        <form action="${baseURL}/postController/uploadPost" method="post" enctype="multipart/form-data">
            <input type="hidden" value="${networkId}" name="networkId">        
            <textarea rows="5" cols="70" name="textData"> </textarea> <br>

            <label for="upload_media" >
                <input type="file" name="networkPost" id="upload_media" class="btn btn-info"/>
            </label> <br>
            <input type="submit" value="Post" class="btn btn-info">
        </form>
</center>
