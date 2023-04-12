import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class HoM  {
	public static void main(String[] args) throws IOException {
		
		int height=1080;
		int width=1920;
		
		int startm=0;
		int finm=3600;
		
		float dep=(float)3;
		float mirl1=0.5f;
		
		
		float dist=(float)1;
		float sqsz=(float)0.01/6f;
		
		boolean[][] grav = new boolean[8000][28];
		
		float[] mirlist = new float[7801];
		float[] deplist = new float[7801];
		float[] lflist = new float[7801];
		
		int count;
		
		int nbframe=0;
		
		Random rg = new Random(543543);
		
		float linfac=(float)255/dep;
		
		int i,j,k,l,m,n,o,p,q,pw,ph,tmp;
		
		int mult=1;
		
		
		int height2=height*mult;
		int width2=width*mult;
		
		byte r;
		
		int currentpix;
		
		
		
	    
	    BufferedImage image = new BufferedImage(width2,height2,BufferedImage.TYPE_3BYTE_BGR);
		
		
		float msqsz=-sqsz;
		float multy=((float)(1-width))*sqsz/(float)2;
		float multz=((float)(height-1))*sqsz/(float)2;
		
		float[] addy = new float[4];
		float[] addz = new float[4];
		float[] vectmp = new float[4];
		float[] vecn = new float[4];
		float[][] vecl = new float[height][width];
		
			
		float[] pos = new float[4];
		float[] inv = new float[4];
		
		int[] fin = new int[4];
		
		int[] t1= {1,0,3,2,5,4,7,6,9};
		int ptmp,rr,ff;

		
		float[] x = new float[4];
		float[] y = new float[4];
		float[] z = new float[4];
		float[] w = new float[4];
		
		float[] xf = new float[4];
		float[] yf = new float[4];
		float[] zf = new float[4];
		float[] wf = new float[4];
		
		float[] newx = new float[4];
		float[] newy = new float[4];
		float[] newz = new float[4];
		float[] neww = new float[4];
		
		int[] tmpcol = new int[3];
		
		float[] vec = new float[4];
		
		byte min=0;
		
		float[] coll = new float[4];
		
		boolean[][][][][] bounds = new boolean[4][11][11][11][11];
		boolean[][][][][][][][][] boundsmir = new boolean[11][11][11][11][4][2][3][3][3];
		
		byte[] tmpcolor = new byte[3];
		byte[][][][][] colors = new byte[11][11][11][11][3];
		byte[][][][][] colors2 = new byte[11][11][11][11][3];
		int[] current = new int[4];
		int[] currentini = new int[4];
		
		int[] index = new int[4];
		int[] ngt = new int[4];
		int[] ngt2 = new int[4];
		int[] bound = new int[5];
		
		float alpf;
		
		int tmpri;
		
		float rsin = (float)Math.sin(Math.PI/600f);
		float rcos = (float)Math.cos(Math.PI/600f);
		
		float[][] mirpos = new float[4][4];
		float[][] miradd = new float[4][4];
		
		float[][][][][] colfrq = new float[11][11][11][11][3];
		
		int[] tmpb = new int[4];
		int[] fmap = new int[3];
		int[] tc = new int[4];
		int[][] hyp = new int[8][4];
		int pp=0;
		int pp2=0;
		
		
		float mirl2=1-mirl1;

		boolean[] revo = new boolean[4];
		int[] tmpo = new int[4];
		int[] tmpoo = new int[3];

		boolean inloop;

		
		for(i=0;i<=300;i++)
		{
			mirlist[i]=0.01f;
			deplist[i]=(50f/300f)*i;
			lflist[i]=0f;
		}
		
		for(i=301;i<=600;i++)
		{
			mirlist[i]=0.01f;
			deplist[i]=50f;
			lflist[i]=0f;
			
			grav[i][20]=true;
		}
		
		
		for(i=601;i<=900;i++)
		{
			mirlist[i]=0.01f;
			deplist[i]=50f;
			lflist[i]=0f;
			
			grav[i][20]=true;
			grav[i][8]=true;
		}
		
		for(i=901;i<=1200;i++)
		{
			mirlist[i]=0.01f;
			deplist[i]=50f;
			lflist[i]=0f;
			
			grav[i][0]=true;
			grav[i][19]=true;
		}
		
		for(i=1201;i<=1300;i++)
		{
			mirlist[i]=0.01f;
			deplist[i]=50f;
			lflist[i]=0f;
			
			grav[i][15]=true;
			grav[i][0]=true;
		}
		
		for(i=1301;i<=1430;i++)
		{
			mirlist[i]=0.01f;
			deplist[i]=50f;
			lflist[i]=0f;
			
			grav[i][11]=true;
		}
		
		for(i=1431;i<=1700;i++)
		{
			mirlist[i]=0.01f;
			deplist[i]=50f;
			lflist[i]=0f;
			
			grav[i][0]=true;
			grav[i][2]=true;
			grav[i][4]=true;
			grav[i][8]=true;
			grav[i][10]=true;
		}
		
		for(i=1701;i<=2400;i++)
		{
			mirlist[i]=0.01f;
			deplist[i]=50f;
			lflist[i]=0f;
			
			grav[i][17]=true;
		}
		
		for(i=2401;i<=2800;i++)
		{
			mirlist[i]=0.01f;
			deplist[i]=50f;
			lflist[i]=0f;
			
			grav[i][0]=true;
			grav[i][19]=true;
		}
		
		for(i=2801;i<=2860;i++)
		{
			mirlist[i]=0.01f;
			deplist[i]=50f;
			lflist[i]=0f;
			
			grav[i][9]=true;
		}
		
		for(i=2861;i<=3000;i++)
		{
			mirlist[i]=0.01f;
			deplist[i]=50f;
			lflist[i]=0f;
			
			grav[i][0]=true;
		}
		
		for(i=3001;i<=3180;i++)
		{
			mirlist[i]=0.01f;
			deplist[i]=50f;
			lflist[i]=0f;
			
			grav[i][7]=true;
		}
		
		for(i=3181;i<=3300;i++)
		{
			mirlist[i]=0.01f;
			deplist[i]=50f;
			lflist[i]=0f;
			
			grav[i][1]=true;
			grav[i][2]=true;
			grav[i][4]=true;
			grav[i][8]=true;
			grav[i][10]=true;
		}
		
		for(i=3301;i<=3600;i++)
		{
			mirlist[i]=0.01f;
			deplist[i]=50f;
			lflist[i]=0.000568562f*i-1.87682f;
			
		}
		
		xf[0]=1;
		yf[1]=1;
		zf[2]=1;
		wf[3]=1;
		
		x[0]=1;
		y[1]=1;
		z[2]=1;
		w[3]=1;
		
		for(i=0;i<10;i++)
		{
			for(j=0;j<10;j++)
			{
				for(k=0;k<10;k++)
				{
					for(l=0;l<10;l++)
					{
						tmpcolor[0]=(byte)(rg.nextDouble()*256);
						tmpcolor[1]=(byte)(rg.nextDouble()*256);
						tmpcolor[2]=(byte)(rg.nextDouble()*256);
						while(tmpcolor[0]>=0 && tmpcolor[1]>=0 && tmpcolor[2]>=0) {
							tmpcolor[0]=(byte)(rg.nextDouble()*256);
							tmpcolor[1]=(byte)(rg.nextDouble()*256);
							tmpcolor[2]=(byte)(rg.nextDouble()*256);
						}
						colors[i][j][k][l][0]=tmpcolor[0];
						colors[i][j][k][l][1]=tmpcolor[1];
						colors[i][j][k][l][2]=tmpcolor[2];
						
						colfrq[i][j][k][l][0]=(float)rg.nextDouble();
						if(colfrq[i][j][k][l][0]<0.2) colfrq[i][j][k][l][0]+=0.1;
						colfrq[i][j][k][l][1]=(float)rg.nextDouble();
						if(colfrq[i][j][k][l][1]<0.2) colfrq[i][j][k][l][1]+=0.1;
						colfrq[i][j][k][l][2]=(float)rg.nextDouble();
						if(colfrq[i][j][k][l][2]<0.2) colfrq[i][j][k][l][2]+=0.1;
					}
				}
			}
		}
		
		colors[5][5][5][5][0]=(byte)255;
		colors[5][5][5][5][1]=(byte)255;
		colors[5][5][5][5][2]=(byte)255;
		
		bounds[0][5][5][5][5]=true;
		
		//
		vec[0]=1;
		
		pos[0]=(float) 5.5;
		pos[1]=(float) 5.5;
		pos[2]=(float) 5.5;
		pos[3]=(float) 5.5;
		current[0]=(int)pos[0];
		current[1]=(int)pos[1];
		current[2]=(int)pos[2];
		current[3]=(int)pos[3];
		currentini[0]=current[0];
		currentini[1]=current[1];
		currentini[2]=current[2];
		currentini[3]=current[3];
		//
		
		for(i=0;i<4;i++)
		{
			vec[i]=dist*x[i]+multy*y[i]+multz*z[i];
			addy[i]=sqsz*y[i];
			addz[i]=msqsz*z[i];
		}
		
		
		for(ph=0;ph<height;ph++)
		{
			for(i=0;i<4;i++) vectmp[i]=vec[i];
			for(pw=0;pw<width;pw++)
			{
				vecl[ph][pw]=(float)1/((float)Math.sqrt(vec[0]*vec[0]+vec[1]*vec[1]+vec[2]*vec[2]+vec[3]*vec[3]));
				for(i=0;i<4;i++) vec[i]+=addy[i];
			}
			for(i=0;i<4;i++) vec[i]=vectmp[i]+addz[i];
		}
	    ///////////////////////////////////////////////////////////////////////////////////
		
		for(i=1;i<=50;i++)
		{
			current[0]=5;
			current[1]=5;
			current[2]=5;
			current[3]=5;
			ptmp=8;
			for(j=0;j<10;j++)
			{
				tmp=(int)(rg.nextDouble()*8);
				while(tmp==t1[ptmp] || (tmp==0 && current[0]==9) || (tmp==1 && current[0]==0) || 
				(tmp==2 && current[1]==9) || (tmp==3 && current[1]==0) || (tmp==4 && current[2]==9) ||
				(tmp==5 && current[2]==0) || (tmp==6 && current[3]==9) || (tmp==7 && current[3]==0))
				{
					tmp=(int)(rg.nextDouble()*8);
				}
				if(tmp==0)
				{
					current[0]++;
					bounds[0][current[0]][current[1]][current[2]][current[3]]=true;
				}
				else if(tmp==1)
				{
					bounds[0][current[0]][current[1]][current[2]][current[3]]=true;
					current[0]--;
				}
				else if(tmp==2)
				{
					current[1]++;
					bounds[1][current[0]][current[1]][current[2]][current[3]]=true;
				}
				else if(tmp==3)
				{
					bounds[1][current[0]][current[1]][current[2]][current[3]]=true;
					current[1]--;
				}
				else if(tmp==4)
				{
					current[2]++;
					bounds[2][current[0]][current[1]][current[2]][current[3]]=true;
				}
				else if(tmp==5)
				{
					bounds[2][current[0]][current[1]][current[2]][current[3]]=true;
					current[2]--;
				}
				else if(tmp==6)
				{
					current[3]++;
					bounds[3][current[0]][current[1]][current[2]][current[3]]=true;
				}
				else if(tmp==7)
				{
					bounds[3][current[0]][current[1]][current[2]][current[3]]=true;
					current[3]--;
				}
				ptmp=tmp;
			}
		}
		fin[0]=current[0];
		fin[1]=current[1];
		fin[2]=current[2];
		fin[3]=current[3];
		
	    ////////////////////////////////////////////////////////////////////////////////////
		for(i=0;i<10;i++){
		for(j=0;j<10;j++){
		for(k=0;k<10;k++){
		for(l=0;l<10;l++){
		for(m=0;m<4;m++){
		for(n=0;n<2;n++){
		for(o=0;o<3;o++){
		for(p=0;p<3;p++){
		for(q=0;q<3;q++){
			
			count=0;
			if(o!=1) count++;
			if(p!=1) count++;
			if(q!=1) count++;
			
			if(m==0)
			{
				fmap[0]=1;
				fmap[1]=2;
				fmap[2]=3;
			}
			else if(m==1)
			{
				fmap[0]=0;
				fmap[1]=2;
				fmap[2]=3;
			}
			else if(m==2)
			{
				fmap[0]=0;
				fmap[1]=1;
				fmap[2]=3;
			}
			else if(m==3)
			{
				fmap[0]=0;
				fmap[1]=1;
				fmap[2]=2;
			}
			
			boundsmir[i][j][k][l][m][n][o][p][q]=true;
			
			if(count==1)
			{
				tmpb[0]=i;
				tmpb[1]=j;
				tmpb[2]=k;
				tmpb[3]=l;
				
				if(n==1) tmpb[m]++;
				
				tc[0]=tmpb[0];
				tc[1]=tmpb[1];
				tc[2]=tmpb[2];
				tc[3]=tmpb[3];
				
				tc[fmap[0]]+=(o-1);
				tc[fmap[1]]+=(p-1);
				tc[fmap[2]]+=(q-1);
				
				if(tc[0]>0 && tc[1]>0 && tc[2]>0 && tc[3]>0)
				{
					if(bounds[m][tc[0]][tc[1]][tc[2]][tc[3]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
				}
				
				if(o!=1) {pp=fmap[0];pp2=o/2;}
				else if(p!=1) {pp=fmap[1];pp2=p/2;}
				else if(q!=1) {pp=fmap[2];pp2=q/2;}
				
				tc[0]=i;
				tc[1]=j;
				tc[2]=k;
				tc[3]=l;
				
				tc[pp]+=pp2;
				
				if(tc[0]>0 && tc[1]>0 && tc[2]>0 && tc[3]>0)
				{
					if(!bounds[pp][tc[0]][tc[1]][tc[2]][tc[3]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
				}
				else boundsmir[i][j][k][l][m][n][o][p][q]=false;
			}
			else if(count==2)
			{
				for(rr=0;rr<4;rr++) {
				hyp[rr][0]=i;
				hyp[rr][1]=j;
				hyp[rr][2]=k;
				hyp[rr][3]=l;
				}
				ff=1;
				
				tmpb[0]=i;
				tmpb[1]=j;
				tmpb[2]=k;
				tmpb[3]=l;
				
				if(n==1) tmpb[m]++;
				
				tc[0]=tmpb[0];
				tc[1]=tmpb[1];
				tc[2]=tmpb[2];
				tc[3]=tmpb[3];
				
				if(o!=1) 
				{
					tc[fmap[0]]+=(o-1);
					hyp[ff][fmap[0]]+=(o-1);
					ff++;
					
					if(tc[0]>0 && tc[1]>0 && tc[2]>0 && tc[3]>0)
					{
						if(bounds[m][tc[0]][tc[1]][tc[2]][tc[3]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					tc[fmap[0]]-=(o-1);
				}
				
				if(p!=1) 
				{
					tc[fmap[1]]+=(p-1);
					hyp[ff][fmap[1]]+=(p-1);
					ff++;
					
					if(tc[0]>0 && tc[1]>0 && tc[2]>0 && tc[3]>0)
					{
						if(bounds[m][tc[0]][tc[1]][tc[2]][tc[3]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					tc[fmap[1]]-=(p-1);
				}
				
				if(q!=1) 
				{
					tc[fmap[2]]+=(q-1);
					hyp[ff][fmap[2]]+=(q-1);
					ff++;
					
					if(tc[0]>0 && tc[1]>0 && tc[2]>0 && tc[3]>0)
					{
						if(bounds[m][tc[0]][tc[1]][tc[2]][tc[3]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					tc[fmap[2]]-=(q-1);
				}
				
				hyp[ff][fmap[0]]+=(o-1);
				hyp[ff][fmap[1]]+=(p-1);
				hyp[ff][fmap[2]]+=(q-1);
				
				tc[fmap[0]]+=(o-1);
				tc[fmap[1]]+=(p-1);
				tc[fmap[2]]+=(q-1);
				
				if(tc[0]>0 && tc[1]>0 && tc[2]>0 && tc[3]>0)
				{
					if(bounds[m][tc[0]][tc[1]][tc[2]][tc[3]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
				}
				
				bound=boundary(hyp[0],hyp[1]);
				if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
				{
					if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
				}
				else boundsmir[i][j][k][l][m][n][o][p][q]=false;
				bound=boundary(hyp[0],hyp[2]);
				if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
				{
					if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
				}
				else boundsmir[i][j][k][l][m][n][o][p][q]=false;
				bound=boundary(hyp[3],hyp[1]);
				if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
				{
					if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
				}
				else boundsmir[i][j][k][l][m][n][o][p][q]=false;
				bound=boundary(hyp[3],hyp[2]);
				if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
				{
					if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
				}
				else boundsmir[i][j][k][l][m][n][o][p][q]=false;
			}
			else if(count==3)
			{
				for(rr=0;rr<8;rr++) {
					hyp[rr][0]=i;
					hyp[rr][1]=j;
					hyp[rr][2]=k;
					hyp[rr][3]=l;
					}
					ff=1;
					
					tmpb[0]=i;
					tmpb[1]=j;
					tmpb[2]=k;
					tmpb[3]=l;
					
					if(n==1) tmpb[m]++;
					
					tc[0]=tmpb[0];
					tc[1]=tmpb[1];
					tc[2]=tmpb[2];
					tc[3]=tmpb[3];
					
					tc[fmap[0]]+=(o-1);
					hyp[ff][fmap[0]]+=(o-1);
					ff++;
					
					if(tc[0]>0 && tc[1]>0 && tc[2]>0 && tc[3]>0)
					{
						if(bounds[m][tc[0]][tc[1]][tc[2]][tc[3]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					tc[fmap[0]]-=(o-1);
					
					tc[fmap[1]]+=(p-1);
					hyp[ff][fmap[1]]+=(p-1);
					ff++;
					
					if(tc[0]>0 && tc[1]>0 && tc[2]>0 && tc[3]>0)
					{
						if(bounds[m][tc[0]][tc[1]][tc[2]][tc[3]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					tc[fmap[1]]-=(p-1);
					
					tc[fmap[2]]+=(q-1);
					hyp[ff][fmap[2]]+=(q-1);
					ff++;
					
					if(tc[0]>0 && tc[1]>0 && tc[2]>0 && tc[3]>0)
					{
						if(bounds[m][tc[0]][tc[1]][tc[2]][tc[3]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					tc[fmap[2]]-=(q-1);
					
					
					tc[fmap[0]]+=(o-1);
					tc[fmap[1]]+=(p-1);
					hyp[ff][fmap[0]]+=(o-1);
					hyp[ff][fmap[1]]+=(p-1);
					ff++;
					
					if(tc[0]>0 && tc[1]>0 && tc[2]>0 && tc[3]>0)
					{
						if(bounds[m][tc[0]][tc[1]][tc[2]][tc[3]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					tc[fmap[0]]-=(o-1);
					tc[fmap[1]]-=(p-1);
					
					tc[fmap[0]]+=(o-1);
					tc[fmap[2]]+=(q-1);
					hyp[ff][fmap[0]]+=(o-1);
					hyp[ff][fmap[2]]+=(q-1);
					ff++;
					
					if(tc[0]>0 && tc[1]>0 && tc[2]>0 && tc[3]>0)
					{
						if(bounds[m][tc[0]][tc[1]][tc[2]][tc[3]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					tc[fmap[0]]-=(o-1);
					tc[fmap[2]]-=(q-1);
					
					tc[fmap[1]]+=(p-1);
					tc[fmap[2]]+=(q-1);
					hyp[ff][fmap[1]]+=(p-1);
					hyp[ff][fmap[2]]+=(q-1);
					ff++;
					
					if(tc[0]>0 && tc[1]>0 && tc[2]>0 && tc[3]>0)
					{
						if(bounds[m][tc[0]][tc[1]][tc[2]][tc[3]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					tc[fmap[1]]-=(p-1);
					tc[fmap[2]]-=(q-1);
					
					tc[fmap[0]]+=(o-1);
					tc[fmap[1]]+=(p-1);
					tc[fmap[2]]+=(q-1);
					hyp[ff][fmap[0]]+=(o-1);
					hyp[ff][fmap[1]]+=(p-1);
					hyp[ff][fmap[2]]+=(q-1);
					ff++;
					
					if(tc[0]>0 && tc[1]>0 && tc[2]>0 && tc[3]>0)
					{
						if(bounds[m][tc[0]][tc[1]][tc[2]][tc[3]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}

					
					
					
					bound=boundary(hyp[0],hyp[1]);
					if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
					{
						if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					else boundsmir[i][j][k][l][m][n][o][p][q]=false;
					
					bound=boundary(hyp[4],hyp[1]);
					if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
					{
						if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					else boundsmir[i][j][k][l][m][n][o][p][q]=false;
					
					bound=boundary(hyp[4],hyp[2]);
					if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
					{
						if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					else boundsmir[i][j][k][l][m][n][o][p][q]=false;
					
					bound=boundary(hyp[2],hyp[0]);
					if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
					{
						if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					else boundsmir[i][j][k][l][m][n][o][p][q]=false;
					
					
					bound=boundary(hyp[5],hyp[3]);
					if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
					{
						if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					else boundsmir[i][j][k][l][m][n][o][p][q]=false;
					
					bound=boundary(hyp[5],hyp[7]);
					if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
					{
						if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					else boundsmir[i][j][k][l][m][n][o][p][q]=false;
					
					bound=boundary(hyp[7],hyp[6]);
					if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
					{
						if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					else boundsmir[i][j][k][l][m][n][o][p][q]=false;
					
					bound=boundary(hyp[6],hyp[3]);
					if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
					{
						if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					else boundsmir[i][j][k][l][m][n][o][p][q]=false;
					
					bound=boundary(hyp[4],hyp[7]);
					if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
					{
						if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					else boundsmir[i][j][k][l][m][n][o][p][q]=false;
					
					bound=boundary(hyp[6],hyp[2]);
					if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
					{
						if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					else boundsmir[i][j][k][l][m][n][o][p][q]=false;
					
					bound=boundary(hyp[5],hyp[1]);
					if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
					{
						if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					else boundsmir[i][j][k][l][m][n][o][p][q]=false;
					
					bound=boundary(hyp[3],hyp[0]);
					if(bound[1]>0 && bound[2]>0 && bound[3]>0 && bound[4]>0)
					{
						if(!bounds[bound[0]][bound[1]][bound[2]][bound[3]][bound[4]]) boundsmir[i][j][k][l][m][n][o][p][q]=false;
					}
					else boundsmir[i][j][k][l][m][n][o][p][q]=false;
			}
		}
		}
		}
		}
		}
		}
		}		
		}
		}
		
		///////////////////////////////////////////////////////////////////////////////////
		
		
	
	    
	    final byte[] pixels =((DataBufferByte) image.getRaster().getDataBuffer()).getData();
	 
	    while(nbframe<=finm)
	    {
	    			if(grav[nbframe][0])
		    		{
		    			for(i=0;i<4;i++) pos[i]+=x[i]/500.0;
		    		}
		    		if(grav[nbframe][1])
		    		{
		    			 for(i=0;i<4;i++) pos[i]-=x[i]/500.0;
		    		}
		    		if(grav[nbframe][2])
		    		{
		    			 for(i=0;i<4;i++) pos[i]-=y[i]/500.0;
		    		}
		    		if(grav[nbframe][3])
		    		{
		    			 for(i=0;i<4;i++) pos[i]+=y[i]/500.0;
		    		}
		    		if(grav[nbframe][4])
		    		{
		    			for(i=0;i<4;i++) pos[i]+=z[i]/500.0;
		    		}
		    		if(grav[nbframe][5])
		    		{
		    			for(i=0;i<4;i++) pos[i]-=z[i]/500.0;
		    		}
		    		if(grav[nbframe][6])
		    		{
		    			 for(i=0;i<4;i++) pos[i]-=w[i]/500.0;
		    		}
		    		if(grav[nbframe][7]) 
		    		{
		    			 for(i=0;i<4;i++) pos[i]+=w[i]/500.0;
		    		}
		    		
		    		//////////////////////////////////////////////////////////////////////////////////////////
					if(grav[nbframe][20])
					{
					for(i=0;i<4;i++) pos[i]+=xf[i]/500.0;
					}
					if(grav[nbframe][21])
					{
					for(i=0;i<4;i++) pos[i]-=xf[i]/500.0;
					}
					if(grav[nbframe][22])
					{
					for(i=0;i<4;i++) pos[i]-=yf[i]/500.0;
					}
					if(grav[nbframe][23])
					{
					for(i=0;i<4;i++) pos[i]+=yf[i]/500.0;
					}
					if(grav[nbframe][24])
					{
					for(i=0;i<4;i++) pos[i]+=zf[i]/500.0;
					}
					if(grav[nbframe][25])
					{
					for(i=0;i<4;i++) pos[i]-=zf[i]/500.0;
					}
					if(grav[nbframe][26])
					{
					for(i=0;i<4;i++) pos[i]-=wf[i]/500.0;
					}
					if(grav[nbframe][27]) 
					{
					for(i=0;i<4;i++) pos[i]+=wf[i]/500.0;
					}
					////////////////////////////////////////////////////////////////////////////////////////////
		    		
		    		
		    		if(grav[nbframe][8]) {
			    			for(i=0;i<4;i++)
			    			{
			    				newx[i]=x[i]*rcos+rsin*y[i];
			    				newy[i]=y[i]*rcos-rsin*x[i];
			    				x[i]=newx[i];
			    				y[i]=newy[i];
			    			}
		    		}
		    		
		    		if(grav[nbframe][9])
		    		{
			    			for(i=0;i<4;i++)
			    			{
			    				newx[i]=x[i]*rcos-rsin*y[i];
			    				newy[i]=y[i]*rcos+rsin*x[i];
			    				x[i]=newx[i];
			    				y[i]=newy[i];
			    			}
		    			
		    		}
		    		
		    		
		    		if(grav[nbframe][10])
		    			{
		    				for(i=0;i<4;i++)
			    			{
			    				newy[i]=y[i]*rcos-rsin*z[i];
			    				newz[i]=z[i]*rcos+rsin*y[i];
			    				y[i]=newy[i];
			    				z[i]=newz[i];
			    			}
		    			}
		    		if(grav[nbframe][11])
		    			{
		    				for(i=0;i<4;i++)
			    			{
			    				newx[i]=x[i]*rcos+rsin*w[i];
			    				neww[i]=w[i]*rcos-rsin*x[i];
			    				x[i]=newx[i];
			    				w[i]=neww[i];
			    			}
		    			}
		    		if(grav[nbframe][12])
		    			{
		    				for(i=0;i<4;i++)
			    			{
			    				newz[i]=z[i]*rcos+rsin*w[i];
			    				neww[i]=w[i]*rcos-rsin*z[i];
			    				z[i]=newz[i];
			    				w[i]=neww[i];
			    			}
		    			}
		    		if(grav[nbframe][13])
		    			{
		    				for(i=0;i<4;i++)
			    			{
			    				newy[i]=y[i]*rcos-rsin*w[i];
			    				neww[i]=w[i]*rcos+rsin*y[i];
			    				y[i]=newy[i];
			    				w[i]=neww[i];
			    			}
		    			}
		    		if(grav[nbframe][14])
		    			{
			    			for(i=0;i<4;i++)
			    			{
			    				newx[i]=x[i]*rcos+rsin*z[i];
			    				newz[i]=z[i]*rcos-rsin*x[i];
			    				x[i]=newx[i];
			    				z[i]=newz[i];
			    			}
		    			}
		    		
		    		
		    		if(grav[nbframe][15])
		    			{
		    				for(i=0;i<4;i++)
			    			{
			    				newy[i]=y[i]*rcos+rsin*z[i];
			    				newz[i]=z[i]*rcos-rsin*y[i];
			    				y[i]=newy[i];
			    				z[i]=newz[i];
			    			}
		    			}
		    		if(grav[nbframe][16])
		    			{
		    				for(i=0;i<4;i++)
			    			{
			    				newx[i]=x[i]*rcos-rsin*w[i];
			    				neww[i]=w[i]*rcos+rsin*x[i];
			    				x[i]=newx[i];
			    				w[i]=neww[i];
			    			}
		    			}
		    		if(grav[nbframe][17])
		    			{
		    				for(i=0;i<4;i++)
			    			{
			    				newz[i]=z[i]*rcos-rsin*w[i];
			    				neww[i]=w[i]*rcos+rsin*z[i];
			    				z[i]=newz[i];
			    				w[i]=neww[i];
			    			}
		    			}
		    		if(grav[nbframe][18])
		    			{
		    				for(i=0;i<4;i++)
			    			{
			    				newy[i]=y[i]*rcos+rsin*w[i];
			    				neww[i]=w[i]*rcos-rsin*y[i];
			    				y[i]=newy[i];
			    				w[i]=neww[i];
			    			}
		    			}
		    		if(grav[nbframe][19])
		    			{
			    			for(i=0;i<4;i++)
			    			{
			    				newx[i]=x[i]*rcos-rsin*z[i];
			    				newz[i]=z[i]*rcos+rsin*x[i];
			    				x[i]=newx[i];
			    				z[i]=newz[i];
			    			}
		    			}
		    		
		    		if(nbframe>=startm) {
		    			mirl1=mirlist[nbframe];
		    	    	mirl2=1-mirl1;
		    	    	dep=deplist[nbframe];
		    	    	linfac=(float)255/dep;
		    			
		    			for(i=0;i<10;i++)
						{
							for(j=0;j<10;j++)
							{
								for(k=0;k<10;k++)
								{
									for(l=0;l<10;l++)
									{
										
										
										tmpcol[0]=colors[i][j][k][l][0];
										tmpcol[1]=colors[i][j][k][l][1];
										tmpcol[2]=colors[i][j][k][l][2];
										
										if(tmpcol[0]<0) tmpcol[0]+=256;
										if(tmpcol[1]<0) tmpcol[1]+=256;
										if(tmpcol[2]<0) tmpcol[2]+=256;
										
										tmpcol[0]+=7*lflist[nbframe]*30*Math.sin(0.25f*0.25f*colfrq[i][j][k][l][0]*nbframe);
										if(tmpcol[0]<0) tmpcol[0]=0;
										else if(tmpcol[0]>255) tmpcol[0]=255;
										
										tmpcol[1]+=7*lflist[nbframe]*30*Math.sin(0.25f*0.25f*colfrq[i][j][k][l][1]*nbframe);
										if(tmpcol[1]<0) tmpcol[1]=0;
										else if(tmpcol[1]>255) tmpcol[1]=255;
										
										tmpcol[2]+=7*lflist[nbframe]*30*Math.sin(0.25f*0.25f*colfrq[i][j][k][l][2]*nbframe);
										if(tmpcol[2]<0) tmpcol[2]=0;
										else if(tmpcol[2]>255) tmpcol[2]=255;
										
										colors2[i][j][k][l][0]=(byte)tmpcol[0];
										colors2[i][j][k][l][1]=(byte)tmpcol[1];
										colors2[i][j][k][l][2]=(byte)tmpcol[2];
										
										
									}
								}
							}
						}
			    	 
			    	currentpix=0;
			    	for(i=0;i<4;i++)
			    	{
			    		vec[i]=dist*x[i]+multy*y[i]+multz*z[i];
			    		addy[i]=sqsz*y[i];
			    		addz[i]=msqsz*z[i];
			    	}
			    	
			    	current[0]=(int)pos[0];
					current[1]=(int)pos[1];
					current[2]=(int)pos[2];
					current[3]=(int)pos[3];
					currentini[0]=current[0];
					currentini[1]=current[1];
					currentini[2]=current[2];
					currentini[3]=current[3];
			    	
			 	    for(ph=0;ph<height;ph++)
			 	    {
			 	    	for(i=0;i<4;i++) vectmp[i]=vec[i];
			 	    	for(pw=0;pw<width;pw++)
			 	    	{
			 	    		
			 	    		for(i=0;i<4;i++)
			 	    		{
			 	    			vec[i]+=lflist[nbframe]*0.02f*(float)Math.sin(0.5*0.25*(float)nbframe+0.4*(float)pw/6f)*y[i];
			 	    			vec[i]+=lflist[nbframe]*0.02f*(float)Math.sin(0.5*0.25*(float)nbframe+0.25*(float)ph/6f)*z[i];
			 	    		}
			 	    		
			 	    		for(i=0;i<4;i++)
			 				{
			 	    			revo[i]=false;
			 					vecn[i]=vec[i]*vecl[ph][pw];
			 					current[i]=currentini[i];
			 					ngt[i]=(2*(Float.floatToIntBits(vecn[i])>>>31)-1)*-1;
			 					ngt2[i]=((Float.floatToIntBits(vecn[i])>>>31)+1)%2;
			 					inv[i]=1/vecn[i];
			 					coll[i]=inv[i]*((current[i]+ngt2[i])-pos[i]);
			 					inv[i]*=ngt[i];
			 					
			 					for(r=0;r<4;r++) 
			 					{
				 					miradd[i][r]=(inv[i]*vecn[r])%1;
				 					if(miradd[i][r]<0) miradd[i][r]+=1;
				 					
				 					mirpos[i][r]=(vecn[r]*coll[i]+pos[r])%1;
				 					if(mirpos[i][r]<0) mirpos[i][r]+=1;
			 				    }
			 				}
			 				

			 				index[0]=current[0];
			 				index[1]=current[1];
			 				index[2]=current[2];
			 				index[3]=current[3];
			 	    		
			 				
			 				inloop=true;
			 				
			 				while(inloop)
			 				{
			 					if(coll[0]<coll[1]) min=0;
				 				else min=1;
				 				if(coll[2]<coll[min]) min=2;
				 				if(coll[3]<coll[min]) min=3;
				 				
				 				if(coll[min]>dep) inloop=false;
				 				else
				 				{
					 				index[min]+=ngt2[min];
					 				
					 				if(bounds[min][index[0]][index[1]][index[2]][index[3]])
					 				{
					 					current[min]+=ngt[min];
					 					index[min]+=ngt[min];
					 					index[min]-=ngt2[min];
					 					
					 					coll[min]+=inv[min];
					 					
					 					for(r=0;r<4;r++) mirpos[min][r]=(miradd[min][r]+mirpos[min][r])%1;
					 				}
					 				else
					 				{
					 					rr=0;
					 					for(r=0;r<4;r++)
					 					{
					 						if(mirpos[min][r]<mirl1)
					 						{
					 							if(revo[r]) tmpo[r]=2;
					 							else tmpo[r]=0;
					 						}
					 						else if(mirpos[min][r]>mirl2)
					 						{
					 							if(revo[r]) tmpo[r]=0;
					 							else tmpo[r]=2;
					 						}
					 						else tmpo[r]=1;
					 						
					 						if(r!=min)
					 						{
					 							tmpoo[rr]=tmpo[r];
					 							rr++;
					 						}
					 					}
					 					
					 					if(boundsmir[current[0]][current[1]][current[2]][current[3]][min][ngt2[min]][tmpoo[0]][tmpoo[1]][tmpoo[2]])
					 					{
					 						index[min]-=ngt2[min];
					 						
					 						ngt2[min]=1-ngt2[min];
					 						ngt[min]=-ngt[min];
					 						revo[min]=!revo[min];
					 						
					 						
						 					
						 					coll[min]+=inv[min];
						 					
						 					for(r=0;r<4;r++) mirpos[min][r]=(miradd[min][r]+mirpos[min][r])%1;
					 					}
					 					else
					 					{
					 						inloop=false;
					 					}
					 				}
				 				}
			 				}
			 	    		
			 				
			 	    		if(coll[min]>dep) alpf=0;
			 	    		else alpf=(255-linfac*coll[min])/255;
			 	    		
			 				
			 				tmpri=colors2[current[0]][current[1]][current[2]][current[3]][0];
			 				if(tmpri<0) tmpri+=256;
			 				tmpri*=alpf;
			 	    		pixels[currentpix]=(byte)tmpri;
			 	    		currentpix++;
			 	    		tmpri=colors2[current[0]][current[1]][current[2]][current[3]][1];
			 				if(tmpri<0) tmpri+=256;
			 				tmpri*=alpf;
			 	    		pixels[currentpix]=(byte)tmpri;
			 	    		currentpix++;
			 	    		tmpri=colors2[current[0]][current[1]][current[2]][current[3]][2];
			 				if(tmpri<0) tmpri+=256;
			 				tmpri*=alpf;
			 	    		pixels[currentpix]=(byte)tmpri;
			 	    		currentpix++;
			 				
			 	    		for(i=0;i<4;i++)
			 	    		{
			 	    			vec[i]-=lflist[nbframe]*0.02f*(float)Math.sin(0.5*0.25*(float)nbframe+0.4*(float)pw/6f)*y[i];
			 	    			vec[i]-=lflist[nbframe]*0.02f*(float)Math.sin(0.5*0.25*(float)nbframe+0.25*(float)ph/6f)*z[i];
			 	    		}
			 	    		
			 	    		for(i=0;i<4;i++) vec[i]+=addy[i];
			 	    	}
			 	    	
			 	    	for(i=0;i<4;i++) vec[i]=vectmp[i]+addz[i];
			 	    }

			       
			          ImageIO.write(image, "bmp", new File("C:/test/img"+String.format("%04d", nbframe)+".bmp/"));
				      System.out.println(nbframe);
		    		}
			       nbframe++;
			       
	    	
	    }
	
	}
	
	public static boolean[] dectobin(int byt)
	{
		boolean[] ret = new boolean[8];
		int i;
		int tmp=byt;
		
		for(i=7;i>=0;i--)
		{
			tmp=byt%2;
			if(tmp==1) ret[i]=true;
			byt-=tmp;
			byt/=2;
		}
		
		return ret;
	}
	
	public static int[] boundary(int[] c1, int[] c2)
	{
		int i;
		int[] ret = new int[5];
		
		for(i=0;i<4;i++)
		{
			if(c1[i]!=c2[i])
			{
				ret[0]=i;
				ret[i+1]=(int)Math.max(c1[i], c2[i]);
			}
			else ret[i+1]=c1[i];
		}
		
		return ret;
	}
	
}