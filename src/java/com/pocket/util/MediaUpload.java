
package com.pocket.util;

import com.pocket.model.Member;
import com.pocket.model.Network;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.multipart.MultipartFile;

public class MediaUpload 
{
    private MultipartFile file;
    private Member member;
    private Integer network;

    public MediaUpload(MultipartFile file, Member member, Integer network)
    {
        this.file = file;
        this.member = member;
        this.network = network;
    } 
    
    private File generatePath(String path)
    {           
        path = path.substring(0,path.lastIndexOf("build"));
        File uploadDir = new File(path, "/web/assets/upload");
        File memberDir = new File(uploadDir, "/"+member.getMemberId());
        
        if(network==null){
            return memberDir;
        }
        
        File networkDir = new File(memberDir,"/"+network);
        return networkDir;
    }
    
    public static void createMemberFolder(String path,int memberId)
    {
        path = path.substring(0,path.lastIndexOf("build")); 
        File uploadDir = new File(path, "/web/assets/upload");
        File memberDir = new File(uploadDir, "/"+memberId);       
        if(!memberDir.exists()){
            memberDir.mkdir();
            System.out.println("Member Directory DONE");
        }
    }
    
    public static void createNetworkFolder(String path,int memberId,int networkId)
    {
        path = path.substring(0,path.lastIndexOf("build")); 
        File uploadDir = new File(path, "/web/assets/upload");
        File memberDir = new File(uploadDir, "/"+memberId);       
        File networkDir = new File(memberDir,"/"+networkId);
        if(!networkDir.exists()){
            networkDir.mkdir();
        }
    }
    
    public static void createJoinNetworkFolder(String path,int networkId,int memberId)
    {
        path = path.substring(0,path.lastIndexOf("build")); 
        File uploadDir = new File(path, "/web/assets/upload");
        File memberDir = new File(uploadDir, "/"+memberId);       
        File networkDir = new File(memberDir,"/"+networkId);
        if(!networkDir.exists()){
            networkDir.mkdir();
        }
    }

        
    public String uploadPostPic(String path,String name)
    {      
        File directory = generatePath(path);        
        
        try
        {
            String ext = name.substring(name.lastIndexOf("."));
            byte arr[] = file.getBytes();
            
            System.out.println("ARRRR Length : " + arr.length);
            if(arr.length==0){
                throw new RuntimeException("Image Size is Zero !");
            }
            
            String fileName = System.currentTimeMillis() + ext;
            
            File file = new File(directory, fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(arr);
            fos.close();
            return fileName;
        } 
        catch (Exception ex) 
        {
            System.err.println("ERRR : " + ex.getMessage());
        }
        return null;
    }
    
    public String uploadProfilePic(String path)
    {      
        File directory = generatePath(path);
        
        try
        {
            byte arr[] = file.getBytes();
            
            System.out.println("ARRRR Length : " + arr.length);
            if(arr.length==0){
                throw new RuntimeException("Image Size is Zero !");
            }
            
            String fileName = System.currentTimeMillis() + ".jpg";
            
            File file = new File(directory, fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(arr);
            fos.close();
            return fileName;
        } 
        catch (Exception ex) 
        {
            System.err.println("ERRR : " + ex.getMessage());
        }
        return null;
    }    
    
    
     public String uploadNetworkPic(String path)
     {         
        File directory = generatePath(path);
 
        try
        {
            byte arr[] = file.getBytes();
            
            System.out.println("ARRRR Length : " + arr.length);
            if(arr.length==0){
                throw new RuntimeException("Image Size is Zero !");
            }
            
            String fileName = System.currentTimeMillis() + ".jpg";
            
            File file = new File(directory, fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(arr);
            fos.close();
            return fileName;
        } 
        catch (Exception ex) 
        {
            System.err.println("ERRR : " + ex.getMessage());
        }
        return null;
    }    
    
}
