package com.pocket.controller;

import com.pocket.dao.MemberDao;
import com.pocket.dao.NetworkDao;
import com.pocket.dao.NetworkMemberDao;
import com.pocket.dao.PostDao;
import com.pocket.model.Member;
import com.pocket.model.Network;
import com.pocket.model.NetworkMember;
import com.pocket.model.Post;
import com.pocket.modelweb.NetworkInvitation;
import com.pocket.util.MediaUpload;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/postController")
public class PostController 
{
    @Autowired
    PostDao postDao;
    
    @Autowired
    NetworkDao networkDao;
    
    @Autowired
    NetworkMemberDao networkmemDao;

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public ModelAndView postNetwork(int networkId) 
    {
        ModelAndView mv = new ModelAndView("uploadPostinclude");
        mv.addObject("networkId", networkId);
        return mv;
    }

    
    @RequestMapping(value = "/uploadPost", method = RequestMethod.POST)
    public String uploadPost(int networkId, MultipartFile networkPost,
            String textData,
            HttpServletRequest request) 
    {
        System.out.println("in NETWORK -POST UPLOAD");
        String uploadFileName = networkPost.getOriginalFilename();
        
        System.out.println("uploadFileName  >>>>>>" + uploadFileName);
        
        Member member = (Member) request.getSession().getAttribute("member");
        String p = request.getServletContext().getRealPath("/");
        
        MediaUpload upload = new MediaUpload(networkPost, member, new Integer(networkId));
        String fileName = upload.uploadPostPic(p,uploadFileName);
        
        Post post = new Post();
       // NetworkMember netwMemb = networkmemDao.getByMemberNetworkId(member.getMemberId(), networkId);

        //System.out.println(netwMemb.getNetworkMemberId());
        post.setPostBy(member.getMemberId());        
        post.setTextData(textData);
        post.setPostType("multimedia");
        post.setPostDate(new Date());
        post.setPostActive(true);
        post.setNetworkId(networkId);
        post.setMediaPath(fileName);
        int postId = postDao.save(post);        
        return "redirect:/member/home?postId="+postId;
    }
    
    @RequestMapping(value = "/viewpost", method = RequestMethod.GET)
    public ModelAndView viewNetworkPost(int networkId) 
    {
        ModelAndView mv = new ModelAndView("seeNetworkPosts");
        
        Network network = networkDao.getByID(networkId);
        mv.addObject("network", network);
        
        List<Post> posts = postDao.listByNetwork(networkId);
        mv.addObject("posts", posts);
        return mv;
    }
}
