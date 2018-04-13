package krishnas.csvapp;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Personal on 13-04-2018.
 */

public class Sendtodb extends AsyncTask<data,String,String> {
        Context context;
        AlertDialog alertDialog;
    public TextView txtv;

    Sendtodb (Context ctx){
            context=ctx;
        }
        @Override
        protected String doInBackground(data... params) {

            String id=params[0].getId();
            String name=params[0].getName();
            String college=params[0].getCollege();
            long contact_no=params[0].getContact_no();
            String address=params[0].getAddress();
            String selected=params[0].getSelected();
            String log_url="http://192.168.43.97/csv/sendtodatabase.php";
            URL url;
            try {
                url = new URL(log_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("id", "UTF-8")+"="+
                        URLEncoder.encode(id, "UTF-8")+"&" +
                        URLEncoder.encode("name", "UTF-8")+"="+
                        URLEncoder.encode(name, "UTF-8")+"&"+
                        URLEncoder.encode("college", "UTF-8")+"="+
                        URLEncoder.encode(college, "UTF-8")+"&"+
                        URLEncoder.encode("contact", "UTF-8")+"="+
                        URLEncoder.encode(String.valueOf(contact_no), "UTF-8")+"&"+
                        URLEncoder.encode("address", "UTF-8")+"="+
                        URLEncoder.encode(address, "UTF-8")+"&"+
                        URLEncoder.encode("selected", "UTF-8")+"="+
                        URLEncoder.encode(selected, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result +=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
           // alertDialog =new AlertDialog.Builder(context).create();
            //alertDialog.setTitle("Send Status");
        }
        @Override
        protected void onPostExecute(String s) {
            //alertDialog.setMessage(s);
            //alertDialog.show();
            Toast.makeText(context,s,Toast.LENGTH_LONG).show();

        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }

