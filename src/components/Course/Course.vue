<template>
  <section class="section-item">
    <div class="section-item__block" data-index="1"></div>
    <div class="section-item__text">
      <div class="text-title">「2022年6月30日」</div>
      <div class="text-desc">6个热爱MC的孩子突发奇想想开一个高版本小游戏服务器，于是WindCraft就诞生了</div>
    </div>
  </section>
  <section class="section-item">
    <div class="section-item__block" data-index="2"></div>
    <div class="section-item__text">
      <div class="text-title">「2022年7月1日」</div>
      <div class="text-desc">首次一测，许多玩家通过B站而来</div>
    </div>
  </section>
  <section class="section-item">
    <div class="section-item__block" data-index="3"></div>
    <div class="section-item__text">
      <div class="text-title">「2022年7月4日」</div>
      <div class="text-desc">开启二测，加入了单方块等新模式</div>
    </div>
  </section>
  <section class="section-item">
    <div class="section-item__block" data-index="4"></div>
    <div class="section-item__text">
      <div class="text-title">「2022年7月7日」</div>
      <div class="text-desc">开服整一周，就68人了！！</div>
    </div>
  </section>
  <section class="section-item">
    <div class="section-item__block" data-index="5"></div>
    <div class="section-item__text">
      <div class="text-title">「2022年7月10日」</div>
      <div class="text-desc">开服10天，加入了宾果等新模式，目前人数100人！</div>
    </div>
  </section>
  <section class="section-item">
    <div class="section-item__block" data-index="6"></div>
    <div class="section-item__text">
      <div class="text-title">「2022年7月16日」</div>
      <div class="text-desc">
        加入了鱿鱼游戏，迁移到了MCSM面板管理 <br>
        WindCraft的故事还在继续，敬请期待~
      </div>
    </div>
  </section>
</template>

<script>
const wh = window.innerHeight
const sectionBlock = Array.from(document.querySelectorAll('.section-item__block'))
window.addEventListener('scroll', function () {
  sectionBlock.forEach(el => {
    const { bottom, top} = el.getBoundingClientRect()
    if (bottom <= 0 || top >= wh) return
    const y = document.documentElement.scrollTop * 0.28
    el.style.backgroundPosition = `center -${y}px`
  })
})
</script>

<style>

*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  width: 100%;
  height: 100%;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}

.section-item {
  width: 100vw;
  height: 45vh;
  position: relative;
  display: flex;
  overflow: hidden;
}

.section-item__block {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-size: 120%;
  background-repeat: no-repeat;
  background-position: center 0;
  transform: translate3d(0, 0, 0);
  will-change: background-position;
}

.section-item__block::before {
  position: absolute;
  top: 0;
  left: 0;
  content: '';
  display: block;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.35);
  transition: background-color 0.3s ease;
}

.section-item:hover .section-item__block::before {
  background-color: rgba(0, 0, 0, 0.2);
}

.section-item__text {
  position: relative;
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  font-family: HannotateSC-W5;
  color: #F1F1F1;
}

.section-item__text .text-title {
  font-size: 24px;
  font-weight: bolder;
  margin-bottom: 20px;
}

.section-item:nth-child(1n) .section-item__block {
  background-image: url('/src/assets/CoursePage/serverimg1.jpg');
}

.section-item:nth-child(2n) .section-item__block {
  background-image: url('/src/assets/CoursePage/serverimg2.jpg');
}

.section-item:nth-child(3n) .section-item__block {
  background-image: url('/src/assets/CoursePage/serverimg3.jpg');
}

.section-item:nth-child(4n) .section-item__block {
  background-image: url('/src/assets/CoursePage/serverimg4.jpg');
}

.section-item:nth-child(5n) .section-item__block {
  background-image: url('/src/assets/CoursePage/serverimg5.jpg');
}

.section-item:nth-child(6n) .section-item__block {
  background-image: url('/src/assets/CoursePage/serverimg6.jpg');
}
</style>

<link href="https://fonts.googleapis.com/css2?family=Long+Cang&display=swap" rel="stylesheet">