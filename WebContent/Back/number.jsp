<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,java.awt.*,java.awt.image.*,javax.imageio.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!  
    Color getRandColor(int fc,int bc){  
        Random random = new Random();  
        if(fc > 255){  
            fc = 255;  
        }  
        if(bc < 255){  
            bc = 255;  
        }  
        int r = fc +random.nextInt(bc-fc);  
        int g = fc +random.nextInt(bc-fc);  
        int b = fc +random.nextInt(bc-fc);  
          
          
        return new Color(r,g,b);  
    }  
%>  
  
<%   
    //设置页面不缓存  
    response.setHeader("Pragma","no-cache");  
    response.setHeader("Cache-Control","no-catch");  
    response.setDateHeader("Expires",0);  
      
    //在内存中创建图象  
    int width = 70;  
    int height = 40;  
    BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);  
      
    //创建图象  
    Graphics g = image.getGraphics();  
    //生成随机对象  
    Random random = new Random();  
    //设置背景色  
    g.setColor(getRandColor(200,250));  
    g.fillRect(0,0,width,height);  
    //设置字体  
    g.setFont(new Font("Tines Nev Roman",Font.PLAIN,22));  
    //随机产生干扰线  
    g.setColor(getRandColor(160,200));  
    for(int i = 0; i < 255; i++){  
        int x = random.nextInt(width);  
        int y = random.nextInt(height);  
        int xl = random.nextInt(12);  
        int yl = random.nextInt(12);  
    }  
    //随机产生认证码,4位数字  
    String sRand = "";  
 String []sel = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
   
   for(int i = 0; i < 4; i++){  
    	int index = (int)(Math.random()*36);
        String rand = sel[index];
        sRand  += rand;  
        //将认证码显示到图象中  
        g.setColor(new Color(20 + random.nextInt(110),20 + random.nextInt(110),20 + random.nextInt(110)));  
        g.drawString(rand,13*i+6,24);  //更改在图像上的位置
    }  
    session.setAttribute("rCode",sRand);  
    //图像生效  
    g.dispose();  
    //输出图像到页面  
    ImageIO.write(image,"JPEG",response.getOutputStream());  
    out.clear();  
    out = pageContext.pushBody();  
%>  
</body>
</html>