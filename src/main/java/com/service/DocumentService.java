package com.service;

import com.Data.Document;
import com.Data.StudentDocument;
import com.RuanxieApplication;
import com.mapper.DocumentMapper;
import com.mapper.StudentDocumentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class DocumentService {

    String[] status= new String[20];
    @Autowired(required=false)
    private DocumentMapper documentMapper;
    @Autowired(required=false)
    private StudentDocumentMapper studentDocumentMapper;
    SqlSession sqlSession ;
    public DocumentService() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();

        documentMapper=sqlSession.getMapper(DocumentMapper.class);
        studentDocumentMapper=sqlSession.getMapper(StudentDocumentMapper.class);
        status[0]="文件上传成功！";
        status[1]="文件上传失败";
        status[2]="文件不存在";
    }

    private static final String UPLOAD_DIR = "/document";


    public String getStatus(int i) {
        return status[i];
    }
    public boolean check(int documentID){

        Document document=documentMapper.getDocumentById(documentID);
        if(document==null){
            return false;
        }
        return true;
    }
    public int updateDocument(MultipartFile file){
        String ID= RuanxieApplication.maplog.FindID();
        try {
            // 创建上传目录（如果不存在）
            Path uploadPath = Paths.get(Path(ID));
            String path=Path(Path(ID),file.getOriginalFilename());
            System.out.println(path);
            Document document=documentMapper.getDocumentByaddress(path);
            if(document==null){
                Files.createDirectories(uploadPath);
                document=new Document();
                System.out.println(documentMapper.getMaxDocumentID());
                document.setDocumentID(documentMapper.getMaxDocumentID()+1);
                document.setAddress(path);
                documentMapper.addDocument(document);
                StudentDocument studentDocument=new StudentDocument(ID,document.getDocumentID());
                System.out.println(studentDocument);
                studentDocumentMapper.addStudentDocument(studentDocument);
                sqlSession.commit();
            }
            // 将上传的文件保存到目标路径
            Path targetPath = uploadPath.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public Resource downloadFile(int DocumentID){
        Document document=documentMapper.getDocumentById(DocumentID);
        if(document==null){
            return null;
        }
        // 读取文件并返回字节数组
        Path filePath = Paths.get(document.getAddress());
        Resource fileResource = new FileSystemResource(filePath);
        return fileResource;
    }
    public List<com.Data1.Document> QueryAll(){
        List<Document> documents=documentMapper.getDocumentByStudentID(RuanxieApplication.maplog.FindID());
        List<com.Data1.Document> documentList=new ArrayList<>();
        for(Document document:documents){
            com.Data1.Document document1=new com.Data1.Document(document);
            documentList.add(document1);
        }
        return documentList;
    }
    String Path(String ID){
        return UPLOAD_DIR+"/"+ID;
    }
    String Path(String s,String s1){
        return s+"/"+s1;
    }
}
