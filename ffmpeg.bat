ffmpeg -framerate 60 -i img%%04d.bmp -c:v libx264rgb -crf 0 -qp 0 output.mp4
ffmpeg -i output.mp4 -i hom.mp3 -c copy -map 0:v:0 -map 1:a:0 hom.mp4
pause